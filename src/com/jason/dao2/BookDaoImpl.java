package com.jason.dao2;

import com.jason.model.Book;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @program: c5_1
 * @description:
 * @author: Liu
 * @create: 2018-08-12
 */
public class BookDaoImpl implements BookDao{

    @Override
    public Book getBookById(int id) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
            BookDao dao = session.getMapper(BookDao.class);
            return dao.getBookById(id);
        }finally {
            session.close();
        }
    }

    @Override
    public List<Book> getAllBooks() {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
            BookDao dao = session.getMapper(BookDao.class);
            return dao.getAllBooks();
        }finally {
            session.close();
        }
    }

    @Override
    public int add(Book book) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
            BookDao dao = session.getMapper(BookDao.class);
            return dao.add(book);
        }finally {
            session.close();
        }
    }

    @Override
    public int update(Book book) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
            BookDao dao = session.getMapper(BookDao.class);
            return dao.update(book);
        }finally {
            session.close();
        }
    }

    @Override
    public int deleteById(int id) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
            BookDao dao = session.getMapper(BookDao.class);
            return dao.deleteById(id);
        }finally {
            session.close();
        }
    }
}
