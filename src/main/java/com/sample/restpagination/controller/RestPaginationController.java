package com.sample.restpagination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.restpagination.model.Results;
import com.sample.restpagination.service.RestPaginationService;

@RestController
public class RestPaginationController {
	@Autowired
	RestPaginationService service;
	
	@GetMapping("/results")
	Results getResult(@RequestParam("page") int page ,@RequestParam(value = "size" , defaultValue = "20") int size ){
		return service.getResults(page, size);		
	}
}
