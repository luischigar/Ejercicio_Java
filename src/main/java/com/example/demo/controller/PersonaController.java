package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
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

import com.example.demo.entity.Persona;
import com.example.demo.entityDto.PersonaDto;
import com.example.demo.logic.PersonaLogic;
import com.example.demo.service.PersonaService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/personas")
@Api(tags = "Persona")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private PersonaLogic personaLogic;
	
	@GetMapping
	public List<Persona> readAll(){
		List<Persona> lPersonaIngresoDto = StreamSupport
				.stream(personaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return lPersonaIngresoDto;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody PersonaDto personaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(personaLogic.save(personaDto));
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Persona personaUpdate){
		Optional<Persona> oPersona = personaService.findById(personaUpdate.getIdPersona());
		
		if(!oPersona.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oPersona.get().setNombres(personaUpdate.getNombres());
		oPersona.get().setApellidos(personaUpdate.getApellidos());
		oPersona.get().setCorreo(personaUpdate.getCorreo());
		oPersona.get().setTelefono(personaUpdate.getTelefono());
		oPersona.get().setIdPersona(personaUpdate.getIdPersona());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(oPersona.get()));
	}

}
