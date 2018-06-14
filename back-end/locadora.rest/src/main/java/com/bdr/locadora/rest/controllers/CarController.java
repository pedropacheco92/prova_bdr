package com.bdr.locadora.rest.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdr.locadora.rest.models.Car;
import com.bdr.locadora.rest.services.CarService;

@RequestMapping("/v1/")
@CrossOrigin
@RestController
public class CarController {

	@Autowired
	private CarService carService;

	@RequestMapping(path = "car/{id}", method = GET)
	public String create(@PathVariable Long id) {
		return "criou com " + id;
	}

	@RequestMapping(path = "car", method = GET)
	public Collection<Car> getAllCars() {
		return this.carService.loadAll();
	}

}
