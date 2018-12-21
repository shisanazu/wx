package com.test.common.dao;

import java.util.List;

public interface BaseDao<T> {
    List<T> find(T param);
}
