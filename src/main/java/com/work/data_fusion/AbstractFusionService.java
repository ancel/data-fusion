package com.work.data_fusion;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractFusionService {
	
	private Map<String, DataGroup> dataGroupMap;
	
	public boolean check(List<Data> datas){
		for (Data data : datas) {
			DataGroup group = getGroup(data);
			if (null==group) {
				throw new RuntimeException("");
			}
			if (StringUtils.isBlank(group.getGroupId())){
				throw new RuntimeException("");
			}
			dataGroupMap.put(group.getGroupId(), group);
		}
		return true;
	}
	
	public abstract DataGroup getGroup(Data data);
}
