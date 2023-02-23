package com.example.querydsldemo.career;

import com.example.querydsldemo.career.domain.Appointment;
import com.example.querydsldemo.career.domain.CareerHistory;
import com.example.querydsldemo.career.dto.AppointmentDTO;
import com.example.querydsldemo.career.dto.CareerHistoryDTO;
import com.example.querydsldemo.career.domain.Certification;
import com.example.querydsldemo.career.dto.CertificationToFieldDTO;
import com.example.querydsldemo.career.dto.CertificationToObjDTO;
import com.example.querydsldemo.common.ReferenceResolver;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {ReferenceResolver.class})
public interface CareerHistoryMapper {
    /**
     * From DTO to Domain object
     *
     * @param careerHistoryDTO
     * @return domain object stored in db
     */
    @Mapping(target = "references", ignore = true)
    CareerHistory toCareerHistory(CareerHistoryDTO careerHistoryDTO);

    /**
     * From Domain object to DTO
     *
     * @param careerHistory domain object from db
     * @return DTO object returned
     */
    @Mapping(target = "references", ignore = true)
    @InheritInverseConfiguration
    CareerHistoryDTO toCareerHistoryDTO(CareerHistory careerHistory);

    // Mapping inner classes
    Certification map(CertificationToFieldDTO value);

    Certification map(CertificationToObjDTO value);

    Appointment map(AppointmentDTO value);
}
