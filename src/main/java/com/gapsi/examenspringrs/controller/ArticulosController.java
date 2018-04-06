package com.gapsi.examenspringrs.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gapsi.examenspringrs.exception.ArticuloAlreadyCreatedException;
import com.gapsi.examenspringrs.exception.ArticuloNotFoundException;
import com.gapsi.examenspringrs.model.Articulo;
import com.gapsi.examenspringrs.repository.ArticuloRepository;

@RestController
public class ArticulosController {

	@Autowired
	private ArticuloRepository repository;

	@GetMapping(path = "/v2/articulos")
	public Iterable<Articulo> obtenerArticulos() {
		return repository.findAll();
	}

	@GetMapping(path = "/v2/articulos/{id}")
	public Articulo obtenerArticuloById(@PathVariable String id) {
		Optional<Articulo> optionalArticulo = repository.findById(id);
		if (!optionalArticulo.isPresent()) {
			throw new ArticuloNotFoundException(String.format("El articulo con id %s no existe", id));
		}
		return optionalArticulo.get();
	}

	@PostMapping(path = "/v2/articulos")
	public ResponseEntity<Object> crearArticulo(@Valid @RequestBody Articulo articulo) {
		boolean existsById = repository.existsById(articulo.getId());
		if (existsById) {
			throw new ArticuloAlreadyCreatedException(
					String.format("El articulo con id %s ya ha sido creado anteriormente", articulo.getId()));
		}
		Articulo articuloGuardado = repository.save(articulo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(articuloGuardado.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path = "/v2/articulos/{id}")
	public ResponseEntity<Object> actualizarArticulo(@PathVariable String id, @Valid @RequestBody Articulo articulo) {
		Optional<Articulo> optionalArticulo = repository.findById(id);
		if (!optionalArticulo.isPresent()) {
			throw new ArticuloNotFoundException(String.format("El articulo con id %s no existe", id));
		}
		
		Articulo articuloAGuardar =  optionalArticulo.get();
		articuloAGuardar.setDescripcion(articulo.getDescripcion());
		articuloAGuardar.setModelo(articulo.getModelo());
		repository.save(articuloAGuardar);
		return ResponseEntity.noContent().build();
		
	}

}
