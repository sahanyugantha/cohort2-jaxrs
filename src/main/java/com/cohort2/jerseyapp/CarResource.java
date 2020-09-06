package com.cohort2.jerseyapp;

import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Variant;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.cohort2.jerseyapp.dao.CarDao;
import com.cohort2.jerseyapp.model.CARTYPE;
import com.cohort2.jerseyapp.model.Car;
import com.google.gson.Gson;

@Path("cars")
public class CarResource {
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCars() {
		
		List<Car> cars = CarDao.getInstance().fetchCarData();
		
		Gson gson = new Gson();
		
		String jsonString = gson.toJson(cars);
		
		return Response
				.status(200)
				.entity(jsonString)
				.build();
				
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getSingleCar(@PathParam("id") String cid) {
		
		int carid = Integer.parseInt(cid);
		
		Car car = CarDao.getInstance().fetchACar(carid);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(car);
		
		return Response
				.status(200)
				.entity(jsonString)
				.build();
				
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response addCar() {
		Car car = new Car();
		car.setId(6);
		car.setModel("Prius");
		car.setBrand("Toyota");
		car.setYear(2020);
		car.setType(CARTYPE.SEDAN);
		
		List<Car> cars = CarDao.getInstance().addCarDB(car);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(cars);
		
		return Response
				.status(200)
				.entity(jsonString)
				.build();
	}
}
