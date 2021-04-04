package com.example.springboot.mapper;

import com.example.springboot.model.Hotel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HotelMapper {
    @Select("SELECT * FROM hotel")
    List<Hotel> selectAll();

    @Select("SELECT id, businessDistrict, introduction, services_and_facilities servicesAndFacilities, starRating, src, address " +
            "FROM hotel where id = #{id}")
    Hotel find(@Param("id") int id);

//    在xml文件里定义了
    Hotel findById(@Param("id") int id);

    @Update("UPDATE hotel " +
            "SET businessDistrict=#{hotel.businessDistrict}, introduction=#{hotel.introduction}," +
            "services_and_facilities=#{hotel.servicesAndFacilities}, starRating=#{hotel.starRating}, src=#{hotel.src}," +
            "address=#{hotel.address} " +
            "WHERE id=#{hotel.id}")
    int update(@Param("hotel") Hotel hotel);


    @Insert("INSERT INTO hotel" +
            "(businessDistrict, introduction, services_and_facilities, starRating, src, address) VALUES" +
            "(#{businessDistrict}, #{introduction}, #{servicesAndFacilities}, #{starRating}, #{src}, #{address})")
    int create(Hotel hotel);
}
