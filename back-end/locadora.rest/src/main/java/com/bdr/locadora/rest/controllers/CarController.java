package com.bdr.locadora.rest.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdr.locadora.rest.models.Car;
import com.bdr.locadora.rest.services.CarService;

@RequestMapping("/v1/cars")
@CrossOrigin
@RestController
public class CarController {

	@Autowired
	private CarService carService;

	/**
	 * Create a car
	 *
	 * @param car
	 * @return
	 */
	@RequestMapping(path = "", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
	public Car create(@RequestBody Car car) {
		return this.carService.create(car);
	}

	/**
	 * Edit a car
	 *
	 * @param car
	 * @return
	 */
	@RequestMapping(path = "/{id}", method = PUT, consumes = APPLICATION_JSON_UTF8_VALUE)
	public Car update(@PathVariable Long id, @RequestBody Car car) {
		return this.carService.update(id, car);
	}

	/**
	 * Load a car by Id
	 *
	 * @param id
	 * @return Car
	 */
	@RequestMapping(path = "/{id}", method = GET)
	public Car load(@PathVariable Long id) {
		return this.carService.load(id);
	}

	/**
	 * Load all cars
	 *
	 * @return Collection<Car>
	 */
	@RequestMapping(path = "", method = GET)
	public Collection<Car> loadAll() {
		return this.carService.loadAll();
	}

	/**
	 * Load a car by Id
	 *
	 * @param id
	 * @return Car
	 */
	@RequestMapping(path = "/{id}", method = DELETE)
	public boolean delete(@PathVariable Long id) {
		return this.carService.delete(id);
	}

}
