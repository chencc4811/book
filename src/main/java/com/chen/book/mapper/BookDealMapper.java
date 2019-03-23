package com.chen.book.mapper;

import com.chen.book.entity.Deal;

import java.util.List;

public interface BookDealMapper {
    int insertBookDeal(Deal deal);
    List<Deal> findSellerBookAreaResultMap(Integer buyerId);
}
