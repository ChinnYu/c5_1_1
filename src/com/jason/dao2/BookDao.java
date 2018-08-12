package com.jason.dao2;

import com.jason.model.Book;

import java.util.List;

public interface BookDao {
    public Book getBookById(int id);

    public List<Book> getAllBooks();

    public int add(Book book);//引響行數ddd

    public int update(Book book);

    public int deleteById(int id);

}
