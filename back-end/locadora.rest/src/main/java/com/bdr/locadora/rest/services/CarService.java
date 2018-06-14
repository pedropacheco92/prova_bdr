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
		this.cars.put(1L, new Car(2015, "Fiesta", Color.BLACK));
		this.cars.put(2L, new Car(2014, "Corsa", Color.WHITE));
		this.cars.put(3L, new Car(1992, "Ferrari", Color.RED));
	}

	public Collection<Car> loadAll() {
		return this.cars.values();
	}

	public Car load(Long id) {
		return this.cars.get(id);
	}

	public Car update(Long id) {
		return this.cars.get(id);
	}

}
