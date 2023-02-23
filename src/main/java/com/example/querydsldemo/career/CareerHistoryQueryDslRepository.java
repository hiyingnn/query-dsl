package com.example.querydsldemo.career;

import com.example.querydsldemo.career.domain.CareerHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CareerHistoryQueryDslRepository extends MongoRepository<CareerHistory, String>, QuerydslPredicateExecutor<CareerHistory> {
}
