package com.work.data_fusion.bean;

import java.util.List;

public abstract class DataGroup {
	private List<Data> members;
	
	public List<Data> getMembers() {
		return members;
	}
	public void setMembers(List<Data> members) {
		this.members = members;
	}
	
	public abstract double sim(Data data);
	public abstract String getId();
}
