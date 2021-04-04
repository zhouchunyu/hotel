package com.example.springboot.mapper;

import com.example.springboot.model.Order;
import com.example.springboot.model.RoomType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoomTypeMapper {
    @Select("SELECT * FROM room_type where hotel_id=#{hotel_id}")
    List<RoomType> selectByHotelId(@Param("hotel_id") int hotel_id);

    @Select("SELECT * FROM room_type")
    List<RoomType> selectAll();

    @Insert("insert into room_type (type, num, price, hotel_id, src) values" +
            "(#{roomType.type}, #{roomType.num}, #{roomType.price}, #{roomType.hotelId}, #{roomType.src})")
    int create(@Param("roomType") RoomType roomType);
}
