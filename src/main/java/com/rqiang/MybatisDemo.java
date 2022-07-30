package com.rqiang;


import com.rqiang.mapper.UserMapper;
import com.rqiang.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**代理开发规则
 * 1. 定义与SQL映射文件同名的Mapper接口，并且将Mapper接口和SQL映射文件放置在同一目录下
 * 2. 设置SQL映射文件的namespace属性为Mapper接口全限定名
 * 3. 在Mapper接口中定义方法，方法名就是SQL映射文件中sql语句id，并保持参数类型和返回值类型一致
 * 4. 编码 a. 通过SqlSession的getMapper方法获取Mapper接口的代理对象
 *        b. 调用对应方法完成sql的执行
 */

public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //List<User> users = sqlSession.selectList("com.rqiang.mapper.UserMapper.selectAll"); //入门开发
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class); //代理开发
        List<User> users = userMapper.selectAll();
        System.out.println(users);
        sqlSession.close();
    }
}
