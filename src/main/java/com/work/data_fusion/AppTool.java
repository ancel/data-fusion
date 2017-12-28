package com.work.data_fusion;

import com.work.data_fusion.fusion.DataFusion;
import com.work.data_fusion.loader.DataGroupLoader;
import com.work.data_fusion.loader.DataLoader;
import com.work.data_fusion.service.FusionService;
import com.work.data_fusion.service.FusionServiceBuilder;
import com.work.data_fusion.storage.DataGroupStorage;

public class AppTool {
	public boolean run(String[] args){
		DataGroupLoader dataGroupLoader = null;
		DataLoader dataLoader = null;
		DataFusion dataFusion = null;
		DataGroupStorage dataGroupStorage = null;
		FusionService fusionService = FusionServiceBuilder.create()
				.setDataGroupLoader(dataGroupLoader)
				.setDataLoader(dataLoader)
				.setDataFusion(dataFusion)
				.setDataGroupStorage(dataGroupStorage).build();
		return fusionService.fuse();
	}
}
