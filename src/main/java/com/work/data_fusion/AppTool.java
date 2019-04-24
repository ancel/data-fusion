package com.work.data_fusion;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.work.data_fusion.exception.BusinessException;
import com.work.data_fusion.fusion.DataFusion;
import com.work.data_fusion.loader.DataGroupLoader;
import com.work.data_fusion.loader.DataLoader;
import com.work.data_fusion.service.FusionService;
import com.work.data_fusion.service.FusionServiceBuilder;
import com.work.data_fusion.storage.DataGroupStorage;

public class AppTool {
	public boolean run(String[] args){
		return loadFusionService().fuse();
	}
	
	private FusionService loadFusionService(){
		DataGroupLoader dataGroupLoader = null;
		ServiceLoader<DataGroupLoader> dataServiceLoaderService = ServiceLoader.load(DataGroupLoader.class);
		Iterator<DataGroupLoader> dglItr = dataServiceLoaderService.iterator();
		while(dglItr.hasNext()){
			dataGroupLoader = dglItr.next();
		}
		if(null==dataGroupLoader){
			throw new BusinessException("Not found DataGroupLoader");
		}
		
		DataLoader dataLoader = null;
		ServiceLoader<DataLoader> dataLoaderService = ServiceLoader.load(DataLoader.class);
		Iterator<DataLoader> dlItr = dataLoaderService.iterator();
		while(dlItr.hasNext()){
			dataLoader = dlItr.next();
		}
		if(null==dataLoader){
			throw new BusinessException("Not found DataLoader");
		}
		
		DataFusion dataFusion = null;
		ServiceLoader<DataFusion> dataFuseService = ServiceLoader.load(DataFusion.class);
		Iterator<DataFusion> dfItr = dataFuseService.iterator();
		while(dfItr.hasNext()){
			dataFusion = dfItr.next();
		}
		if(null==dataFusion){
			throw new BusinessException("Not found DataFusion");
		}
		
		DataGroupStorage dataGroupStorage = null;
		ServiceLoader<DataGroupStorage> dataGroupStorageService = ServiceLoader.load(DataGroupStorage.class);
		Iterator<DataGroupStorage> dataGroupStorageItr = dataGroupStorageService.iterator();
		while(dataGroupStorageItr.hasNext()){
			dataGroupStorage = dataGroupStorageItr.next();
		}
		if(null==dataGroupStorage){
			throw new BusinessException("Not found DataGroupStorage");
		}
		
		FusionService fusionService = FusionServiceBuilder.create()
				.setDataGroupLoader(dataGroupLoader)
				.setDataLoader(dataLoader)
				.setDataFusion(dataFusion)
				.setDataGroupStorage(dataGroupStorage).build();
		return fusionService;
	}
	
}
