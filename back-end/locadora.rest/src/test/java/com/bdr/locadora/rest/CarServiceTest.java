package com.bdr.locadora.rest;

import static com.bdr.locadora.rest.models.Color.BLACK;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bdr.locadora.rest.models.Car;
import com.bdr.locadora.rest.services.CarService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CarServiceTest {

	@Autowired
	private CarService carService;

	@Test
	public void testLoad() {
		// given
		Long id = 1L;

		// when
		Car car = this.carService.load(id);

		// then
		assertThat(car).isNotNull();
		assertThat(car.getId()).isEqualTo(1L);
	}

	@Test
	public void testLoadAll() {
		// when
		Collection<Car> cars = this.carService.loadAll();

		// then
		assertThat(cars).isNotEmpty();
		assertThat(cars.size()).isEqualTo(6);
		assertThat(cars.iterator().next().getId()).isEqualTo(1L);
	}

	@Test
	public void testUpdate() {
		// given
		Long id = 1L;
		Car carEdited = new Car(id, "modelo", 2018, BLACK);

		// when
		Car car = this.carService.update(id, carEdited);

		// then
		assertThat(car).isNotNull();
		assertThat(car.getId()).isEqualTo(1L);
		assertThat(car.getModel()).isEqualTo("modelo");
		assertThat(car.getYear()).isEqualTo(2018);
		assertThat(car.getColor()).isEqualTo(BLACK);
	}

	@Test
	public void testCreate() {
		// given
		Car newCar = new Car(null, "modelo2", 2018, BLACK);

		// when
		Car car = this.carService.create(newCar);

		// then
		assertThat(car).isNotNull();
		assertThat(car.getId()).isEqualTo(7L);
		assertThat(car.getModel()).isEqualTo("modelo2");
		assertThat(car.getYear()).isEqualTo(2018);
		assertThat(car.getColor()).isEqualTo(BLACK);
	}

	@Test
	public void testDelete() {
		// given
		Long id = 1L;

		// when
		Boolean deleted = this.carService.delete(id);

		// then
		assertThat(deleted).isTrue();
	}

}
