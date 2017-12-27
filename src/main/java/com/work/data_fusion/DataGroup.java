package com.work.data_fusion;

import java.util.List;

public abstract class DataGroup {
	private List<Data> datas;
	public abstract double sim(Data data);
	public abstract String getGroupId();
	public List<Data> getDatas() {
		return datas;
	}
	public void setDatas(List<Data> datas) {
		this.datas = datas;
	}
	
	public abstract DataGroup getInstance();
}
