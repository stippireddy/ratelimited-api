package com.agoda;


public class Hotel {
	private String city;
	private int hotelID;
	private String room;
	private double price;

	public String getCity() {
		return city;
	}

	public int getHotelID() {
		return hotelID;
	}

	public String getRoom() {
		return room;
	}

	public double getPrice() {
		return price;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
