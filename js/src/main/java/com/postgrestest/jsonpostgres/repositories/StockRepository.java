package com.postgrestest.jsonpostgres.repositories;

import com.postgrestest.jsonpostgres.entity.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {
}
