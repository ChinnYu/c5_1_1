package com.jason.model;

/**
 * @program: c5_1
 * @description: 圖書實體 Bean POJO
 * @author: Liu
 * @create: 2018-08-11
 */
public class Book {
    private int book_Id;
    private String book_title;
    private String book_typename;
    private int book_price;
    private String book_state;

    @Override
    public String toString() {
        return "Book{" +
                "book_Id=" + book_Id +
                ", book_title='" + book_title + '\'' +
                ", book_typename='" + book_typename + '\'' +
                ", book_price=" + book_price +
                ", book_state='" + book_state + '\'' +
                '}';
    }

    public int getBook_Id() {
        return book_Id;
    }

    public void setBook_Id(int book_Id) {
        this.book_Id = book_Id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_typename() {
        return book_typename;
    }

    public void setBook_typename(String book_typename) {
        this.book_typename = book_typename;
    }

    public int getBook_price() {
        return book_price;
    }

    public void setBook_price(int book_price) {
        this.book_price = book_price;
    }

    public String getBook_state() {
        return book_state;
    }

    public void setBook_state(String book_state) {
        this.book_state = book_state;
    }
}
