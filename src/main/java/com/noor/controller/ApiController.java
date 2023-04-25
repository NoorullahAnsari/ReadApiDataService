package com.noor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noor.entity.ApiDataEntity;
import com.noor.service.ApiEntryService;

import kong.unirest.HttpStatus;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ApiController {
	
	@Autowired
	private ApiEntryService apiEntryService;
	
	@GetMapping("/api/data")
	public ResponseEntity<?> findApiData(){
		
		List<ApiDataEntity> apiData = null;
		apiData = apiEntryService.getApiData();
		if(apiData == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiData);		
		
	}
	

	@PostMapping("/api/data")
	public ResponseEntity<?> addApiData(@RequestBody ApiDataEntity apiDataEntity){
		
		apiEntryService.addApiData(apiDataEntity);		
		return ResponseEntity.status(HttpStatus.OK).body("added successfully");
	}
	
	
	
	@PutMapping("/api/data")
	public ResponseEntity<?> updateApiData(@RequestBody ApiDataEntity apiDataEntity, @RequestParam("id")Long id){
		
		apiEntryService.updateApiData(apiDataEntity,id);
		
		
		return ResponseEntity.status(HttpStatus.OK).body("updated");
	}
	
	@DeleteMapping("api/data")
	public ResponseEntity<?> deleteApiDataById(@RequestParam("Id")Long id){
		
		apiEntryService.deleteApiDataById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("");
	}
	
	
}
