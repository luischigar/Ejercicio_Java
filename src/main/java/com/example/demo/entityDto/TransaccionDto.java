package com.example.demo.entityDto;

import java.util.Date;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransaccionDto {
	
	private int valor;
	
	@Type(type="date")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date fecha;
	
	private String descripcion;
	
	private Long idCuenta;

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}
	
}
