package com.bdr.locadora.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/")
@CrossOrigin
@RestController
public class CarController {

	@RequestMapping(path = "car", method = GET)
	public String create() {
		return "criou";
	}

}
