package com.escuela.degollado.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escuela.degollado.model.Alumno;

public interface AlumnoRepo extends JpaRepository<Alumno, Serializable> {

	public List<Alumno> findAll();
	public List<Alumno> findById(int id);
}
