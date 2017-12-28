package com.work.data_fusion.bean;

import java.util.HashMap;
import java.util.Map;

public abstract class Data {
	//数据参与融合的关键字段
	private Map<String, Object> attrs = new HashMap<String, Object>();
	//数据原值
	private String text;

	public Map<String, Object> getAttrs() {
		return attrs;
	}

	public void setAttrs(Map<String, Object> attrs) {
		this.attrs = attrs;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (null == obj) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Data data = (Data) obj;
		if (!getId().equals(data.getId())) {
			return false;
		}
		return true;
	}

	public abstract double sim(Data data);

	public abstract String getId();
}
