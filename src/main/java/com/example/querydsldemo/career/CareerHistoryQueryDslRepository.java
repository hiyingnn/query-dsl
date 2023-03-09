package com.example.querydsldemo.career;

import com.example.querydsldemo.career.domain.CareerHistory;
import com.example.querydsldemo.career.domain.QCareerHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface CareerHistoryQueryDslRepository
  extends MongoRepository<CareerHistory, String>,
  QuerydslPredicateExecutor<CareerHistory>,
  QuerydslBinderCustomizer<QCareerHistory> {
  @Override
  default void customize(QuerydslBindings querydslBindings,
                                QCareerHistory qCareerHistory) {

    querydslBindings.excludeUnlistedProperties(true);
    // your queries will go here
    querydslBindings.bind(qCareerHistory.company).as("company").withDefaultBinding();
    querydslBindings.bind(qCareerHistory.skills).as("skills");
    querydslBindings.including(qCareerHistory.skills, qCareerHistory.company);

  }
}
