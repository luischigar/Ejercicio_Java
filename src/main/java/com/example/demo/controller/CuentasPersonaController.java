package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cuenta;
import com.example.demo.logic.CuentaLogic;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/cuentas_persona")
@Api(tags = "Cuentas Persona")
public class CuentasPersonaController {
	
	@Autowired
	private CuentaLogic cuentaLogic;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id")Long id){
		List<Cuenta> lCuenta = cuentaLogic.obtenerCuentaPersona(id);
		if(lCuenta == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lCuenta);
	}

}
