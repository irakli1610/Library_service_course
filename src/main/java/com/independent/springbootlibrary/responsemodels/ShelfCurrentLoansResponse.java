package com.independent.springbootlibrary.responsemodels;

import com.independent.springbootlibrary.entity.Book;
import lombok.Data;

@Data
public class ShelfCurrentLoansResponse {
    private Book book;
    private int daysLeft;
    public ShelfCurrentLoansResponse(Book book, int daysLeft) {
        this.book=book;
        this.daysLeft=daysLeft;
    }
}
