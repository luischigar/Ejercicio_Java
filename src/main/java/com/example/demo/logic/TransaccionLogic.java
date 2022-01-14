package com.example.demo.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cuenta;
import com.example.demo.entity.Transaccion;
import com.example.demo.entityDto.TransaccionCuentaFechaDto;
import com.example.demo.entityDto.TransaccionDto;
import com.example.demo.service.CuentaService;
import com.example.demo.service.TransaccionService;

@Service
public class TransaccionLogic {
	
	@Autowired
	private TransaccionService transaccionService;
	
	@Autowired
	private CuentaService cuentaService;
	
	public Transaccion save(TransaccionDto transaccionDto) {
		
		Transaccion oTransaccion = new Transaccion();
		Cuenta oCuenta = new Cuenta();
		
		Iterable<Cuenta> lCuenta = cuentaService.findAll();
		
		for(Cuenta item: lCuenta) {
			if(item.getIdCuenta().equals(transaccionDto.getIdCuenta())) {
				oCuenta = item;
			}
		}
		
		oTransaccion.setCuenta(oCuenta);
		oTransaccion.setDescripcion(transaccionDto.getDescripcion());
		oTransaccion.setFecha(transaccionDto.getFecha());
		oTransaccion.setValor(transaccionDto.getValor());
		
		return transaccionService.save(oTransaccion);
	}
	
	public ArrayList<Transaccion> obtenerTransaccionRango(TransaccionCuentaFechaDto transaccionCuentaFechaDto){
		Iterable<Transaccion> lTransaccion = transaccionService.findAll();
		
		ArrayList<Transaccion> listaTransaccion = new ArrayList<Transaccion>();
		
		for(Transaccion item: lTransaccion) {
			
			if((item.getCuenta().getIdCuenta().equals(transaccionCuentaFechaDto.getIdCuenta()))) {
				if(item.getFecha().after(transaccionCuentaFechaDto.getFechaInicio()) && item.getFecha().before(transaccionCuentaFechaDto.getFechaFin())) {
					listaTransaccion.add(item);
				}
				
			}
			
		}
		return listaTransaccion;
		
	}

}
