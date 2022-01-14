package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entityDto.TransaccionDto;
import com.example.demo.logic.TransaccionLogic;
import com.example.demo.service.TransaccionService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/transacciones")
@Api(tags = "Transaccion")
public class TransaccionController {
	
	@Autowired
	private TransaccionService transaccionService;
	
	@Autowired
	private TransaccionLogic transaccionLogic;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody TransaccionDto TransaccionDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(transaccionLogic.save(TransaccionDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		//Optional<User> oUser = userService.findById(id);
		
		if(!transaccionService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		transaccionService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

}
