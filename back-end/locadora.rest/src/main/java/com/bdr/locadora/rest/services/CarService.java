package com.bdr.locadora.rest.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bdr.locadora.rest.models.Car;
import com.bdr.locadora.rest.models.Color;

@Service
public class CarService {

	private Map<Long, Car> cars = new HashMap<>();

	public CarService() {
		this.cars.put(1L, new Car(1L, "Fiesta", 2015, Color.BLACK));
		this.cars.put(2L, new Car(2L, "Corsa", 2014, Color.WHITE));
		this.cars.put(3L, new Car(3L, "Ferrari", 1992, Color.RED));
	}

	public Collection<Car> loadAll() {
		return this.cars.values();
	}

	public Car load(Long id) {
		return this.cars.get(id);
	}

	public Car update(Long id, Car car) {
		if (this.cars.containsKey(id)) {
			this.cars.replace(id, car);
		} else {
			this.cars.put(id, car);
		}
		return car;
	}

	public boolean delete(Long id) {
		return this.cars.remove(id, this.cars.get(id));
	}

	public Car create(Car car) {
		this.cars.keySet().stream().max(Long::compareTo).ifPresent(id -> this.cars.put(id + 1, car));

		return car;
	}

}
