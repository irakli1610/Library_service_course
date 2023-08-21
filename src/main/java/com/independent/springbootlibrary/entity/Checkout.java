package com.independent.springbootlibrary.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "checkout")
@Data
public class Checkout {
    public  Checkout(){}

    public Checkout(
            String userEmail, String checkoutDate, String returnDate, Long bookId
    ){
        this.userEmail=userEmail;
        this.checkoutDate=checkoutDate;
        this.returnDate=returnDate;
        this.bookId=bookId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_email")
     private String userEmail;

    @Column(name = "checkout_date")
     private String  checkoutDate;

    @Column(name = "return_date")
     private String returnDate;

    @Column(name = "book_id")
     private long bookId;
}
