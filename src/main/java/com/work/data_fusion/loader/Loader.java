package com.work.data_fusion.loader;

import java.util.Collection;

public interface Loader<T> {
	public Collection<T> load();
}
