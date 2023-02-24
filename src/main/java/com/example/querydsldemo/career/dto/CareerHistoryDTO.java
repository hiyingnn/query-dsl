package com.example.querydsldemo.career.dto;

import com.example.querydsldemo.common.ReferencesDTO;
import com.example.querydsldemo.config.ValidReference;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldNameConstants
@SuperBuilder
@NoArgsConstructor
@ValidReference
public class CareerHistoryDTO extends ReferencesDTO {
    String id;
    String company;

    Long profileId;

    @Valid AppointmentDTO appointment;
    String duration;
    String lastDrawnSalary;
    List<String> skills;

    List<@Valid CertificationToFieldDTO> certs;
    Long version;

    @Override
    public Set<String> getMandatoryReferences() {
        return Set.of(Fields.company, Fields.skills);
    }

    @Override
    public Set<String> getOptionalReferences() {
        return Set.of(Fields.duration);
    }
}
