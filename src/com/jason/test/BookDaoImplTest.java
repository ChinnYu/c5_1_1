package com.jason.test;

import com.jason.dao2.BookDao;
import com.jason.dao2.BookDaoImpl;
import com.jason.model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: c5_1_1
 * @description:
 * @author: Liu
 * @create: 2018-08-12
 */
public class BookDaoImplTest {
    BookDao dao;
    @Before
    public void before() throws Exception{
        dao = new BookDaoImpl();
    }

    @Test
    public void testgetBookById() throws Exception{
        //BookDao dao = new BookDaoImpl();
        System.out.println(dao.getBookById(7));
    }
    @Test
    public void  testgetAllBooks() throws Exception{
        for (Book book: dao.getAllBooks()) {
            System.out.println(book);
        }
    }
    @Test
    public void testAdd(){
        Book book = new Book();
        book.setBook_typename("電腦");
        book.setBook_state("未借出");
        book.setBook_title("springMVC");
        book.setBook_price(25);
        Assert.assertEquals(1,dao.add(book));
        //System.out.println(dao.add(book));
    }

    @Test
    public void testUpdate(){
        Book book = dao.getBookById(15);
        book.setBook_typename("電腦");
        book.setBook_state("未借出");
        book.setBook_title("springMVC");
        book.setBook_price(25);
        Assert.assertEquals(1,dao.update(book));
    }

    @Test
    public void testDeleteById(){
        Assert.assertEquals(1,dao.deleteById(16));
    }

}
