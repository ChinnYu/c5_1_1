package com.jason.dao;

import com.jason.model.Book;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @program: c5_1
 * @description: 圖書數據訪問
 * @author: Liu
 * @create: 2018-08-11
 */
public class BookDao {
    /**
     *      獲得圖書通過編號
     * @param id
     * @return
     */
    public Book getBookById(int id){
        //將mybatis的設定檔轉換成輸入流，讀配置文件
        InputStream cfg = this.getClass().getClassLoader().getResourceAsStream("mybatis.xml");
        if(cfg!=null){
            System.out.println("123");
        }
        //根據配置文件構建會話工廠
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(cfg);
        //創建會話
        SqlSession session = factory.openSession();
        //調用方法getBookById帶入參數1獲得單個圖書物件
        Book book = session.selectOne("com.jason.mapping.bookMapper.getBookById",id);
        //輸出
        System.out.println(book);
        //關閉會話
        session.close();
        return book;
    }


}
