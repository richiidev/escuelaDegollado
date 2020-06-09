package com.escuela.degollado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.escuela.degollado.model.Alumno;
import com.escuela.degollado.model.Carrera;
import com.escuela.degollado.pojo.Response;
import com.escuela.degollado.service.CarreraService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@Api(tags = " Apis Carrera")
public class CarreraController {

	@Autowired
	CarreraService service;
	
	@GetMapping("/carreras")
	public ResponseEntity<Response> getAllCarreras(){
		try {
			Object response = service.getAllCarreras();
			return new ResponseEntity<Response>(new Response(true,"Success", response),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Response>(new Response(false,"error: "+ e.getMessage(),null),HttpStatus.OK);
		}
	}

	@GetMapping("/carrera/id")
	public ResponseEntity<Response> getById(@RequestParam int id){
		try {
			Object response = service.getByIdCarrera(id);
			return new ResponseEntity<Response>(new Response(true,"Success", response),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Response>(new Response(false,"error: "+ e.getMessage(),null),HttpStatus.OK);
		}
	}

	@DeleteMapping("/carrera/id")
	public ResponseEntity<Response> deleteCarrera(@RequestParam("id") int id) {
		try {
			Object response = service.getByIdCarrera(id);
			service.deleteById(id);
			return new ResponseEntity<Response>(new Response(true, "Success Eliminado", response), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<Response>(new Response(false, "Error " + e.getMessage(), null), HttpStatus.OK);
		}
	}

	// api post agregar
	@PostMapping("/carrera")
	public ResponseEntity<Response> addCarrera(@RequestBody Carrera carrera) {
		try {
			this.service.saveCarrera(carrera);
			Response response = new Response(true, "Success!", carrera);
			return new ResponseEntity<Response>(response, HttpStatus.OK);

		} catch (Exception e) {
			Response response = new Response(false, "Error!, ..." + e.getMessage(), null);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
	}
	// api para modificar
	@PutMapping("/carrera")
	public ResponseEntity<Response> updateCarrera(@RequestBody Carrera carrera) {
		try {
			this.service.updateCarrera(carrera);
			Response response = new Response(true, "Success!", carrera);
			return new ResponseEntity<Response>(response, HttpStatus.OK);

		} catch (Exception e) {
			Response response = new Response(false, "Error!, ..." + e.getMessage(), null);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
	}
}
