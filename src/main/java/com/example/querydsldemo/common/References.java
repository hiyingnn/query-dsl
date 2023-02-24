package com.example.querydsldemo.common;

import com.querydsl.core.annotations.QueryEntity;
import com.querydsl.core.annotations.QuerySupertype;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder(toBuilder = true)
@Data
@NoArgsConstructor
@QuerySupertype
public abstract class References {
  List<Reference> references;

}
