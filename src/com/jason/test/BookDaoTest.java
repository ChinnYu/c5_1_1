package com.jason.test;

import com.jason.dao.BookDao;
import com.jason.model.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;
/**
 * @program: c5_1
 * @description:
 * @author: Liu
 * @create: 2018-08-12
 */
public class BookDaoTest {

    @Test
    public void getBookById(){
        BookDao dao = new BookDao();
        Book book = dao.getBookById(7);
        System.out.println(book);
        //斷言，期待1，實際2
        //Assert.assertEquals(1,2);

        //不為空就通過
        Assert.assertNotNull(book);
    }
}
