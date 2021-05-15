package com.example.demo.dao;

import java.util.*;

public abstract class Dao<T, K>
{
    public abstract T get(K primaryKey);

    public abstract Iterator<T> get(Collection<K> primaryKeys);

    public abstract T add(T obj);

    public abstract Iterator<T> add(Collection<T> objs);

    public abstract T update(K primaryKey, T obj);

    public abstract Iterator<T> update(Map<K, T> map);

    public abstract int delete(K primaryKey);

    public abstract int delete(Collection<K> primaryKeys);
}
