package com.helloworld.quickstart.mappers;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.Objects;

@Mapper
public interface QuickMapper {
    HashMap<String, Object> findById (HashMap<String, Object> paramMap);

    void registerItem(HashMap<String, Object> paramMap);
}
