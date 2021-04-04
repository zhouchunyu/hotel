package com.example.springboot.mapper;

import com.example.springboot.model.Order;
import com.example.springboot.model.RoomType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoomTypeMapper {
    @Select("SELECT id, type, num, price, hotel_id hotelId, src FROM room_type where hotel_id=#{hotel_id}")
    List<RoomType> selectByHotelId(@Param("hotel_id") int hotel_id);

    @Select("SELECT id, type, num, price, hotel_id hotelId, src FROM room_type WHERE id=#{id}")
    RoomType find(@Param("id") int id);

    @Select("SELECT id, type, num, price, hotel_id hotelId, src FROM room_type")
    List<RoomType> selectAll();

    @Insert("insert into room_type (type, num, price, hotel_id, src) values" +
            "(#{roomType.type}, #{roomType.num}, #{roomType.price}, #{roomType.hotelId}, #{roomType.src})")
    int create(@Param("roomType") RoomType roomType);

    @Update("UPDATE room_type SET type=#{type}, num=#{num}, price=#{price}, hotel_id=#{hotelId}, src=#{src}) WHERE " +
            "id=#{id}")
    int update(RoomType roomType);
}
