package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Transaccion;
import com.example.demo.repository.TransaccionRepository;

@Service
public class TransaccionServiceImpl implements TransaccionService {
	
	@Autowired
	private TransaccionRepository transaccionRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Transaccion> findAll() {
		try {
			return transaccionRepository.findAll();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Transaccion> findById(Long id_Transaccion) {
		try {
			return transaccionRepository.findById(id_Transaccion);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional
	public Transaccion save(Transaccion transaccion) {
		try {
			return transaccionRepository.save(transaccion);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional
	public void deleteById(Long id_Transaccion) {
		transaccionRepository.deleteById(id_Transaccion);
		
	}

}
