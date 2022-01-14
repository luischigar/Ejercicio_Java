package com.example.demo.logic;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cuenta;
import com.example.demo.entity.Persona;
import com.example.demo.entityDto.CuentaDto;
import com.example.demo.entityDto.CuentaUpdateDto;
import com.example.demo.service.CuentaService;
import com.example.demo.service.PersonaService;

@Service
public class CuentaLogic {
	
	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private PersonaService personaService;
	
	public Cuenta save(CuentaDto cuentaDto) {
		Cuenta oCuenta = new Cuenta();
		
		Iterable<Persona> lPersona = personaService.findAll();
		
		for(Persona item: lPersona) {
			if(item.getIdPersona().equals(cuentaDto.getIdPersona())) {
				oCuenta.setPersona(item);
			}
		}
		
		oCuenta.setNombreCuenta(cuentaDto.getNombreCuenta());
		oCuenta.setCodigo(cuentaDto.getCodigo());
		oCuenta.setMonto(cuentaDto.getMonto());
		oCuenta.setDescripcion(cuentaDto.getDescripcion());
		
		return cuentaService.save(oCuenta);
	}
	
	public Cuenta update(CuentaUpdateDto cuentaUpdateDto) {
		
		Optional<Cuenta> oCuenta = cuentaService.findById(cuentaUpdateDto.getIdCuenta());
		
		if(!oCuenta.isPresent()) {
			throw new IllegalArgumentException();
		}
		oCuenta.get().setNombreCuenta(cuentaUpdateDto.getNombreCuenta());
		oCuenta.get().setCodigo(cuentaUpdateDto.getCodigo());
		oCuenta.get().setMonto(cuentaUpdateDto.getMonto());
		oCuenta.get().setDescripcion(cuentaUpdateDto.getDescripcion());
		
		return cuentaService.save(oCuenta.get());
	}
	
	public ArrayList<Cuenta> obtenerCuentaPersona(Long id){
		
		Iterable<Cuenta> lCuenta = cuentaService.findAll();
		
		ArrayList<Cuenta> listaCuenta = new ArrayList<Cuenta>();
		
		for(Cuenta item: lCuenta) {
			
			if(item.getPersona().getIdPersona().equals(id)) {
				listaCuenta.add(item);
			}
			
		}
		
		return listaCuenta;
	}

}
