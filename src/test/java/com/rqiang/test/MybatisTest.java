package com.rqiang.test;

import com.rqiang.mapper.BrandMapper;
import com.rqiang.mapper.UserMapper;
import com.rqiang.pojo.Brand;
import com.rqiang.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void testSelectAll() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class); //代理开发
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testSelectBrandAll() throws Exception{
        int id = 1;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class); //代理开发
        List<Brand> brands = (List<Brand>) brandMapper.selectById(id);
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testSelectBrandCondition() throws Exception{
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setCompanyName(companyName);

        Map map = new HashMap();
        map.put("status", status);
        //map.put("companyName", companyName);
        //map.put("brandName", brandName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class); //代理开发
        List<Brand> brands1 = brandMapper.selectByCondition(status, companyName, brandName);
        List<Brand> brands2 = brandMapper.selectByCondition(brand);
        List<Brand> brands3 = brandMapper.selectByCondition(map);
        System.out.println(brands3);
        sqlSession.close();
    }

    @Test
    public void testSelectBrandConditionSingle() throws Exception{
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
        brand.setBrandName(brandName);
//        brand.setStatus(status);
        brand.setCompanyName(companyName);

        Map map = new HashMap();
        map.put("status", status);
        //map.put("companyName", companyName);
        //map.put("brandName", brandName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class); //代理开发
        List<Brand> brands2 = brandMapper.selectByConditionSingle(brand);

        System.out.println(brands2);
        sqlSession.close();
    }

    @Test
    public void testAdd() throws Exception{
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机，手机中的战斗机";
        int ordered = 100;

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class); //代理开发
        brandMapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testAdd2() throws Exception{
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机，手机中的战斗机";
        int ordered = 100;

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class); //代理开发
        brandMapper.add(brand);
        System.out.println(brand.getId());  //主键返回 useGeneratedKeys=true  keyProperty=id(主键)
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testUpdate() throws Exception{
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机，手机中的超级战斗机";
        int ordered = 20000;

        int id = 7;

        Brand brand = new Brand();
        brand.setId(id);
        brand.setStatus(status);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class); //代理开发
        brandMapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelete() throws Exception{
        int id = 8;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class); //代理开发
        brandMapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws Exception{
        int[] ids = {9, 10, 11};

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class); //代理开发
        brandMapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws Exception{
        String username = "zhangsan";
        String password = "123";

        Map map = new HashMap();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        map.put("user", user);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class); //代理开发
        System.out.println(userMapper.selectById(map));
        //System.out.println(userMapper.selectById2(1));
        sqlSession.commit();
        sqlSession.close();
    }


}
