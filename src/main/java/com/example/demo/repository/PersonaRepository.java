package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
