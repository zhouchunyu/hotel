package com.example.springboot.model;

import java.util.Date;

public class Order {

    private int id;
    private int userId;
    private int hotelId;
    private Date checkInTime;
    private Date checkoutTime;
    private int roomTypeId;
    private int roomsCount;
    private int peopleCount;
    private boolean withOrWithoutChildren;

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public boolean isWithOrWithoutChildren() {
        return withOrWithoutChildren;
    }

    public void setWithOrWithoutChildren(boolean withOrWithoutChildren) {
        this.withOrWithoutChildren = withOrWithoutChildren;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", hotelId=" + hotelId +
                ", checkInTime=" + checkInTime +
                ", checkoutTime=" + checkoutTime +
                ", roomTypeId=" + roomTypeId +
                ", roomsCount=" + roomsCount +
                ", peopleCount=" + peopleCount +
                ", withOrWithoutChildren=" + withOrWithoutChildren +
                '}';
    }


}
