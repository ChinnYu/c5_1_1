package com.jason.dao2;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class MyBatisUtil {
    
    //GC不理static
    private static SqlSessionFactory factory=null;
    public static SqlSessionFactory getSqlSessionFactory(){
        if(factory==null){
        // 獲得環境設定檔流
        InputStream config = MyBatisUtil.class.getClassLoader().getResourceAsStream("mybatis.xml");
        // 創建sql會話工廠
        factory = new SqlSessionFactoryBuilder().build(config);
        }
        return factory;
    }
    
    //獲得會話
    public static SqlSession getSession(){
        return getSqlSessionFactory().openSession(true);
    }
    
    /**
     * 獲得得sql會話
     * @param isAutoCommit 是否自動提交，如果為false則需要sqlSession.commit();rollback();
     * @return sql會話
     */
    public static SqlSession getSession(boolean isAutoCommit){
        return getSqlSessionFactory().openSession(isAutoCommit);
    }
    
}
