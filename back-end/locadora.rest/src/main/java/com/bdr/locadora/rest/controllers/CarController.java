package com.bdr.locadora.rest.controllers;

import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Car> create(@RequestBody Car car) {
		// return the created car with status 201 (created)
		return new ResponseEntity<>(carService.create(car), CREATED);
	}

	/**
	 * Edit a car
	 *
	 * @param car
	 * @return
	 */
	@RequestMapping(path = "/{id}", method = PUT, consumes = APPLICATION_JSON_UTF8_VALUE)
	public Car update(@PathVariable Long id, @RequestBody Car car) {
		return carService.update(id, car);
	}

	/**
	 * Load a car by Id If doesen't find a car by id, return blank with status 404
	 *
	 * @param id
	 * @return Car
	 */
	@RequestMapping(path = "/{id}", method = GET)
	public ResponseEntity<Car> load(@PathVariable Long id) {
		Car car = carService.load(id);
		if (nonNull(car)) {
			// if contains car, return it with status 200 (0k)
			return new ResponseEntity<>(car, OK);
		}
		// else, return status 404 (not found)
		return new ResponseEntity<>(NOT_FOUND);
	}

	/**
	 * Load all cars
	 *
	 * @return Collection<Car>
	 */
	@RequestMapping(path = "", method = GET)
	public Collection<Car> loadAll() {
		return carService.loadAll();
	}

	/**
	 * Delete a car by Id, returns no content status
	 *
	 * @param id
	 */
	@RequestMapping(path = "/{id}", method = DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		if (carService.delete(id)) {
			// if deleted return a successful status but with no content
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		// else, return status 404 (not found)
		return new ResponseEntity<>(NOT_FOUND);
	}

}
