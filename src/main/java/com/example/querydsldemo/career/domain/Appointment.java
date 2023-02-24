package com.example.querydsldemo.career.domain;

import com.example.querydsldemo.common.References;
import com.querydsl.core.annotations.QueryEmbeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class Appointment extends References {
    String position;
    String rank;
}
