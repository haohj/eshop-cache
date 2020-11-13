package com.hao.eshopcache.mapper;

import com.hao.eshopcache.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    User findUserInfo(@Param("id") Integer id);

    @Insert("insert into tb_user (name,age) VALUES (#{name},#{age})")
    int insert(User user);
}
