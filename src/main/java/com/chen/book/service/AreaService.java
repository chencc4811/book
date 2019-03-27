package com.chen.book.service;

import com.chen.book.entity.Area;
import com.chen.book.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AreaService {
    @Autowired
    private AreaMapper areaMapper;
    public List<Area> getAreaList(){
        return areaMapper.queryArea();
    }


}
