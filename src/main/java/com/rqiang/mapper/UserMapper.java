package com.rqiang.mapper;

import com.rqiang.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> selectAll();

    User selectById(@Param("map")Map map);

    @Select("select * from tb_user where id = #{id}")
    User selectById2(int id);
}
