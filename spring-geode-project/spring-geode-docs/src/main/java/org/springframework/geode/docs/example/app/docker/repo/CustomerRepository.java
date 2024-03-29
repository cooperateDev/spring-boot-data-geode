/*
 * Copyright 2017-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.springframework.geode.docs.example.app.docker.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.geode.docs.example.app.docker.model.Customer;

/**
 * A Spring Data {@link CrudRepository} and Data Access Object (DAO) used to perform basic CRUD and simple Query
 * data access operations on {@link Customer Customers}.
 *
 * @author John Blum
 * @see org.springframework.data.repository.CrudRepository
 * @see org.springframework.geode.docs.example.app.docker.model.Customer
 * @since 1.3.0
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Customer findByNameLike(String name);

}
