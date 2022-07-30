package com.rqiang.mapper;

import com.rqiang.pojo.Brand;
import com.rqiang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    List<Brand> selectAll();

    List<Brand> selectById(int id);

    /**
     * 条件查询
     *  参数接收
     *      1.散装参数： 方法中有多个参数，需要使用@Param("SQL参数占位符名称")
     *      2.对象参数: 保证SQL中的参数名与实体类属性名对应上，即对象的属性名与参数占位符名称一致
     *      3.map参数： 保证SQL中参数名和map集合的键的名称对应上
     * @param status
     * @param companyName
     * @param brandName
     * @return
     */
    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName,
                                 @Param("brandName") String brandName);

    List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);

    /**
     * 单条件动态生成
     * @param brand
     * @return
     */
    List<Brand> selectByConditionSingle(Brand brand);

    void add(Brand brand);

    int update(Brand brand);

    /**
     * 多个参数：封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
     * map.put("arg0", 参数值1)
     * map.put("param1", 参数值1)
     * map.put("arg1", 参数值2)
     * map.put("param2", 参数值2)
     * --------------------@Param("username")
     * map.put("username", 参数值1)
     * map.put("param1", 参数值1)
     * map.put("arg1", 参数值2)
     * map.put("param2", 参数值2)
     *
     * 单个参数：
     * 1.POJO类型: 直接使用，属性名 和 参数占位符名称一致
     * 2。Map集合: 直接使用，键名 和 参数占位符名称一致
     * 3.Collection: 封装Map集合，建议使用@Param注解，替换Map集合中默认的arg键名
     *      map.put("arg0", collection集合);
     *      map.put("collection", collection集合);
     * 4.List: 封装Map集合，建议使用@Param注解，替换Map集合中默认的arg键名
     *      map.put("arg0", list集合);
     *      map.put("collection", list集合);
     *      map.put("list", list集合);
     * 5.Array: 封装Map集合，建议使用@Param注解，替换Map集合中默认的arg键名
     *      map.put("arg0", 数组);
     *      map.put("array", 数组);
     *
     * 6.其他类型: 直接使用，参数名与参数占位符可以名称不一致
     * map.put("", )
     * map.put("", )
     * map.put("", )
     * map.put("", )
     *
     * @param id
     */
    void deleteById(@Param("id") int id);

    void deleteByIds(@Param("ids") int[] ids);

}
