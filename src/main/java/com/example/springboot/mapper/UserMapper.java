package com.example.springboot.mapper;

import com.example.springboot.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users(username, password, enabled) VALUES" +
            "(#{username}, #{password}, true)")
    int create(User user);

    @Update("UPDATE users SET password=#{password} WHERE username=#{username}" )
    int update(User user);

    @Insert("INSERT INTO authorities(username, authority) VALUES" +
            "(#{username}, 'user')")
    int create_authorities(User user);

    @Select("SELECT * FROM users WHERE username = #{name}")
    User findByName(@Param("name") String name);

    @Select("SELECT * FROM users")
    List<User> selectAll();
}
