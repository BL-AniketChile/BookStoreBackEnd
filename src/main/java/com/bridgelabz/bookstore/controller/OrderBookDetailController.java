package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.exception.BookStoreException;
import com.bridgelabz.bookstore.dto.OrderBookDetailDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.OrderBookDetail;
import com.bridgelabz.bookstore.service.OrderBookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookstore")
@CrossOrigin("*")
public class OrderBookDetailController {

    @Autowired
    OrderBookDetailService orderBookDetailService;

    @PostMapping("/orderbookdetail")
    public ResponseEntity<ResponseDTO> addBook(@Valid @RequestBody OrderBookDetailDTO orderBookDetailDTO) throws BookStoreException {
//            if (result.hasErrors()) {
//                throw new BookStoreException(BookStoreException.ExceptionType.INVALID_DATA, "Invalid Data");
//            }
        int orderBookDetail = orderBookDetailService.addOrderBookSummary(orderBookDetailDTO);
        ResponseDTO responseData = new ResponseDTO("Info Added Successfully", orderBookDetail);
        return new ResponseEntity<ResponseDTO>(responseData,HttpStatus.OK);
    }
}
