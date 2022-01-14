package com.example.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Persona;
import com.example.demo.entityDto.PersonaDto;
import com.example.demo.service.PersonaService;

@Service
public class PersonaLogic {
	
	@Autowired
	private PersonaService personaService;
	
	public Persona save(PersonaDto personaDto) {
		Persona oPersona = new Persona();
		
		oPersona.setNombres(personaDto.getNombres());
		oPersona.setApellidos(personaDto.getApellidos());
		oPersona.setCorreo(personaDto.getCorreo());
		oPersona.setTelefono(personaDto.getTelefono());
		
		return personaService.save(oPersona);
	}

}
