package com.example.querydsldemo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SourceDTO {
  LocalDateTime dateObtained;
  ReferenceType referenceType;
  String comment;

}
