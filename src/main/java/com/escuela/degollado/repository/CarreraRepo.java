package com.escuela.degollado.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escuela.degollado.model.Carrera;

public interface CarreraRepo extends JpaRepository<Carrera, Serializable> {

	public List<Carrera> findAll();
	public List<Carrera> findById(int id);
}
