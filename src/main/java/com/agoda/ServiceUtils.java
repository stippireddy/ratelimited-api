package com.agoda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class ServiceUtils {
	public static List<Hotel> getHotelList() {
		try {
			return new CsvToBeanBuilder<Hotel>(new FileReader("hoteldb.csv")).withType(Hotel.class).build().parse();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<Hotel>();
	}
}
