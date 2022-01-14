package com.example.demo.entityDto;

import java.util.Date;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransaccionCuentaFechaDto {
	
	private Long idCuenta;
	
	@Type(type="date")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date fechaInicio;
	
	@Type(type="date")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date fechaFin;

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}
