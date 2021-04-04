package com.example.springboot.mapper;

import com.example.springboot.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from orders where user_id=#{id}")
    List<Order> selectByUserId(@Param("id") int id);

    @Select("SELECT * FROM orders")
    List<Order> selectAll();

    @Insert("insert into orders (username, hotelId, checkInTime, checkoutTime, roomTypeId, roomsCount, peopleCount," +
            "withOrWithoutChildren) values (#{username}, #{hotelId}, #{checkInTime}, #{checkoutTime}," +
            "#{roomTypeId}, #{roomsCount}, #{peopleCount}, #{withOrWithoutChildren}) ")
    int create(Order order);
}
