package com.example.springboot.model;

import java.util.List;

public class Hotel {
    int id;
    String address;
    String businessDistrict;
    String introduction;
    String servicesAndFacilities;
    String starRating;
    String src;
    List<RoomType> roomTypes;


    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusinessDistrict() {
        return businessDistrict;
    }

    public void setBusinessDistrict(String businessDistrict) {
        this.businessDistrict = businessDistrict;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getServicesAndFacilities() {
        return servicesAndFacilities;
    }

    public void setServicesAndFacilities(String servicesAndFacilities) {
        this.servicesAndFacilities = servicesAndFacilities;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }
}
