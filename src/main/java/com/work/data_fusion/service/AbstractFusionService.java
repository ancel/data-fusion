package com.work.data_fusion.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.work.data_fusion.bean.Data;
import com.work.data_fusion.bean.DataGroup;

public abstract class AbstractFusionService {
	public boolean fuse(){
		Collection<DataGroup> dataGroups = loadDataGroup();
		Map<String, DataGroup> dataGroupMap = new HashMap<String, DataGroup>(dataGroups.size());
		for (DataGroup dataGroup : dataGroups) {
			dataGroupMap.put(dataGroup.getId(), dataGroup);
		}
		Collection<Data> datas = loadData();
		for (Data data : datas) {
			DataGroup fuseResult = fuse(data, dataGroupMap.values());
			dataGroupMap.put(fuseResult.getId(), fuseResult);
		}
		return save(dataGroupMap.values());
	}
	public abstract Collection<DataGroup> loadDataGroup();
	public abstract Collection<Data> loadData();
	public abstract DataGroup fuse(Data data, Collection<DataGroup> dataGroups);
	public abstract boolean save(Collection<DataGroup> dataGroups);
}
