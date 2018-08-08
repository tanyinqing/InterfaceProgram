package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

// 单例模式  任何时候只有一个类的实例
public class MyBatisSession {
//    工厂模式  就是工厂
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            try {  //从配置文件中获得
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }
//从工厂中取得一个产品  SqlSession数据库会话
    public static SqlSession getSqlSession(boolean autoCommit) {
//        是否自动提交  跟事务有关
        return getSqlSessionFactory().openSession(autoCommit);
    }
}
