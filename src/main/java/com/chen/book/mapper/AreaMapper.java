package com.chen.book.mapper;

import com.chen.book.entity.Area;

import java.util.List;

public interface AreaMapper {
    List<Area>queryArea();
    /**
     *
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     *
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     *
     * @param areaId
     * @return
     */
    int deleteArea(long areaId);

    /**
     *
     * @param areaIdList
     * @return
     */
    int batchDeleteArea(List<Long> areaIdList);

}
