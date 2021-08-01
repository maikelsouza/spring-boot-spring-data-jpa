package com.codegate.springdatajpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.codegate.springdatajpa.model.Emprego;

public interface EmpregoRepository extends CrudRepository<Emprego, Long> {

}
