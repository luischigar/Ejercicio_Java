package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

}
