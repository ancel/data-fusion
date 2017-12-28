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
			dataGroupMap.put(dataGroup.getGroupId(), dataGroup);
		}
		Collection<Data> datas = loadData();
		for (Data data : datas) {
			DataGroup fuseResult = fuseData(data, dataGroupMap.values());
			dataGroupMap.put(fuseResult.getGroupId(), fuseResult);
		}
		return save(dataGroupMap.values());
	}
	public abstract Collection<DataGroup> loadDataGroup();
	public abstract Collection<Data> loadData();
	public abstract DataGroup fuseData(Data data, Collection<DataGroup> dataGroups);
	public abstract boolean save(Collection<DataGroup> dataGroups);
}
