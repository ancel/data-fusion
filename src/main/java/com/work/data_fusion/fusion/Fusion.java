package com.work.data_fusion.fusion;

import java.util.Collection;

public interface Fusion<D, G> {
	public abstract G fuse(D data, Collection<G> dataGroups);
}
