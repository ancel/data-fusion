package com.work.data_fusion.service;

import com.work.data_fusion.fusion.DataFusion;
import com.work.data_fusion.loader.DataGroupLoader;
import com.work.data_fusion.loader.DataLoader;
import com.work.data_fusion.storage.DataGroupStorage;

public class FusionServiceBuilder {
	private DataLoader dataLoader;
	private DataGroupLoader dataGroupLoader;
	private DataFusion dataFusion;
	private DataGroupStorage dataGroupStorage;
	
	public static FusionServiceBuilder create(){
		return new FusionServiceBuilder();
	}
	
	
	public FusionServiceBuilder setDataLoader(DataLoader dataLoader) {
		this.dataLoader = dataLoader;
		return this;
	}


	public FusionServiceBuilder setDataGroupLoader(DataGroupLoader dataGroupLoader) {
		this.dataGroupLoader = dataGroupLoader;
		return this;
	}

	public FusionServiceBuilder setDataFusion(DataFusion dataFusion) {
		this.dataFusion = dataFusion;
		return this;
	}


	public FusionServiceBuilder setDataGroupStorage(DataGroupStorage dataGroupStorage) {
		this.dataGroupStorage = dataGroupStorage;
		return this;
	}


	public FusionService build(){
		return new FusionService(dataLoader, dataGroupLoader, dataFusion, dataGroupStorage);
	}
}
