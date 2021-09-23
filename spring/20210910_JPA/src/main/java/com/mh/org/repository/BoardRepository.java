package com.mh.org.repository;

import org.springframework.data.repository.CrudRepository;

import com.mh.org.domain.Customer;

public interface BoardRepository extends CrudRepository<Customer, Long> {

}