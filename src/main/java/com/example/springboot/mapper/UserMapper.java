package com.example.springboot.mapper;

import com.example.springboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users(username, password, enabled) VALUES" +
            "(#{username}, #{password}, true)")
    int create(User user);

    @Insert("INSERT INTO authorities(username, authority) VALUES" +
            "(#{username}, 'user')")
    int create_authorities(User user);

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Select("SELECT * FROM user")
    List<User> selectAll();
}
