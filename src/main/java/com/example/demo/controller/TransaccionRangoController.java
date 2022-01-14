package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entityDto.TransaccionCuentaFechaDto;
import com.example.demo.logic.TransaccionLogic;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/transacciones_rango")
@Api(tags = "Transacciones Rango")
public class TransaccionRangoController {
	
	@Autowired
	private TransaccionLogic transaccionLogic;
	
	@PostMapping
	public ResponseEntity<?> obtenerRangoTransaccion(@RequestBody TransaccionCuentaFechaDto transaccionCuentaFechaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(transaccionLogic.obtenerTransaccionRango(transaccionCuentaFechaDto));
	}

}
