package com.example.querydsldemo.career.dto;

import com.example.querydsldemo.common.ReferencesDTO;
import com.example.querydsldemo.config.ValidReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
@FieldNameConstants
@ValidReference
public class CertificationToFieldDTO extends ReferencesDTO {
    String name;
    String issuedBy;

    @Override
    public Set<String> getMandatoryReferences() {
        return Set.of(Fields.name, Fields.issuedBy);
    }

    @Override
    public Set<String> getOptionalReferences() {
        return Set.of();
    }
}
