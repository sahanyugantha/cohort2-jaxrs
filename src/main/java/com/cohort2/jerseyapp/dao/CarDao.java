package com.cohort2.jerseyapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cohort2.jerseyapp.model.CARTYPE;
import com.cohort2.jerseyapp.model.Car;

public class CarDao {
	
	private static CarDao newInstance = new CarDao();
	
	private  CarDao() {
	}
	
	public static CarDao getInstance() {
		return newInstance;
	}


	
	//Car DB
	/*public List<Car> fetchCarData(){
	
		List<Car> carList = new ArrayList<Car>();
		Car car1 = new Car(1, "Wagon R", "Suzuki", 2020, CARTYPE.WAGON);
		carList.add(car1);
		Car car2 = new Car(2, "Axio", "Toyota", 2010, CARTYPE.SEDAN);
		carList.add(car2);
		Car car3 = new Car(3, "Alto", "Suzuki", 2019, CARTYPE.WAGON);
		carList.add(car3);
		Car car4 = new Car(4, "Premio", "Toyota", 2020, CARTYPE.SEDAN);
		carList.add(car4);
		Car car5 = new Car(5, "GTR", "Nissan", 2020, CARTYPE.COUPE);
		carList.add(car5);
		
		return carList;
	}*/
	
	public List<Car> fetchCarData() {
		
		List<Car> carList = new ArrayList<Car>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cardb", "root", "mysql");
			String sql = "SELECT * FROM tbl_car";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Car car = new Car();
				car.setId(rs.getInt("id"));
				car.setBrand(rs.getString("brand"));
				car.setModel(rs.getString("model"));
				car.setYear(rs.getInt("year"));
				car.setType(CARTYPE.valueOf(rs.getString("type")));
				
				carList.add(car);
				
				//System.out.println(car.toString());
			}
			
			return carList;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Car fetchACar(int id){
		
		List<Car> carList = fetchCarData();
		
		Car car = carList.get(id);
		
		return car;
	}
	
	
	public List<Car> addCarDB(Car car) {
		List<Car> cars = fetchCarData();
		cars.add(car);
		
		return cars;
	}

}
