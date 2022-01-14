package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Cuenta;
import com.example.demo.repository.CuentaRepository;

@Service
public class CuentaServiceImpl implements CuentaService{
	
	@Autowired
	private CuentaRepository cuentaRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Cuenta> findAll() {
		try {
			return cuentaRepository.findAll();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cuenta> findById(Long id_Cuenta) {
		try {
			return cuentaRepository.findById(id_Cuenta);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional
	public Cuenta save(Cuenta cuenta) {
		try {
			return cuentaRepository.save(cuenta);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional
	public void deleteById(Long id_Cuenta) {
		cuentaRepository.deleteById(id_Cuenta);
		
	}

}
