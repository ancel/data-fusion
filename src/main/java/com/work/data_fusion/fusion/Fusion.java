package com.work.data_fusion.fusion;

import java.util.Collection;

import com.work.data_fusion.bean.Data;
import com.work.data_fusion.bean.DataGroup;

public interface Fusion<D extends Data, G extends DataGroup> {
	public abstract G fuse(D data, Collection<G> dataGroups);
}
