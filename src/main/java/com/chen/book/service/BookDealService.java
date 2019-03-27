package com.chen.book.service;
import com.chen.book.entity.Deal;
import com.chen.book.mapper.BookDealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookDealService {
    @Autowired
    private BookDealMapper bookDealMapper;

    public List<Deal> getBuyinfo(Integer buyerId) {
        List<Deal> dealList = bookDealMapper.findSellerBookAreaResultMap(buyerId);
        return dealList;

    }
}
