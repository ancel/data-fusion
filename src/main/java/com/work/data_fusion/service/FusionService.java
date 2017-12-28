package com.work.data_fusion.service;

import java.util.Collection;

import com.work.data_fusion.bean.Data;
import com.work.data_fusion.bean.DataGroup;
import com.work.data_fusion.fusion.DataFusion;
import com.work.data_fusion.loader.DataGroupLoader;
import com.work.data_fusion.loader.DataLoader;
import com.work.data_fusion.storage.DataGroupStorage;

public class FusionService extends AbstractFusionService {
	private DataLoader dataLoader;
	private DataGroupLoader dataGroupLoader;
	private DataFusion fusion;
	private DataGroupStorage dataGroupStorage;
	
	public FusionService(DataLoader dataLoader,
			DataGroupLoader dataGroupLoader, 
			DataFusion fusion,
			DataGroupStorage dataGroupStorage) {
		super();
		this.dataLoader = dataLoader;
		this.dataGroupLoader = dataGroupLoader;
		this.fusion = fusion;
		this.dataGroupStorage = dataGroupStorage;
	}

	@Override
	public Collection<DataGroup> loadDataGroup() {
		return dataGroupLoader.load();
	}

	@Override
	public Collection<Data> loadData() {
		return dataLoader.load();
	}

	@Override
	public DataGroup fuse(Data data, Collection<DataGroup> dataGroups) {
		return fusion.fuse(data, dataGroups);
	}

	@Override
	public boolean save(Collection<DataGroup> dataGroups) {
		return dataGroupStorage.store(dataGroups);
	}
}
