package com.gapsi.examenspringrs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gapsi.examenspringrs.model.Articulo;

@Repository
public interface ArticuloRepository extends CrudRepository<Articulo, String> {

}
