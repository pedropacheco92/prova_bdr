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
		this.cars.put(4L, new Car(4L, "Lamborghini", 2015, Color.YELLOW));
		this.cars.put(5L, new Car(5L, "Uno", 2014, Color.GREEN));
		this.cars.put(6L, new Car(6L, "Jeep", 1992, Color.BLUE));
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
		this.cars.keySet().stream().max(Long::compareTo).ifPresent(id -> {
			car.setId(id + 1);
			this.cars.put(car.getId(), car);
		});

		return car;
	}

}
