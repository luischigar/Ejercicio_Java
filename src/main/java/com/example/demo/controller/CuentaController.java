package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cuenta;
import com.example.demo.entityDto.CuentaDto;
import com.example.demo.entityDto.CuentaUpdateDto;
import com.example.demo.logic.CuentaLogic;
import com.example.demo.service.CuentaService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/cuentas")
@Api(tags = "Cuenta")
public class CuentaController {
	
	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private CuentaLogic cuentaLogic;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CuentaDto cuentaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(cuentaLogic.save(cuentaDto));
	}
	
	@GetMapping
	public List<Cuenta> readAll(){
		List<Cuenta> lPersonaIngresoDto = StreamSupport
				.stream(cuentaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return lPersonaIngresoDto;
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody CuentaUpdateDto cuentaUpdateDto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cuentaLogic.update(cuentaUpdateDto));
	}

}
