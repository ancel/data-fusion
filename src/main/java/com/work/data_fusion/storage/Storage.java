package com.work.data_fusion.storage;

import java.util.Collection;

public interface Storage<T> {
	public abstract boolean store(Collection<T> targets);
}
