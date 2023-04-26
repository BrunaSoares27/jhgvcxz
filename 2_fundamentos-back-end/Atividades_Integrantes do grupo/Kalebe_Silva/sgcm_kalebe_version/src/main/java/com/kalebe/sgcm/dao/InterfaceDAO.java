package com.kalebe.sgcm.dao;

import java.util.List;

public interface InterfaceDAO<T>{
    
    List<T> selectAll();
    T selectByid(long id);
    List<T> selectByTerm(String term);
    int insert(T object);
    int update (T object);
    int delete(Long id);


}
