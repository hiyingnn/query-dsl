package com.example.querydsldemo.career.domain;

import com.example.querydsldemo.common.References;
import com.querydsl.core.annotations.QueryEmbedded;
import com.querydsl.core.annotations.QueryEntity;
import com.querydsl.core.annotations.QuerySupertype;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@TypeAlias("careerHistory")
@SuperBuilder(toBuilder = true)
@Document(collection = "career")
@NoArgsConstructor
public class CareerHistory extends References implements Auditable {
    @MongoId
    String id;
    Long profileId;

    String company;

    Appointment appointment;
    String duration;
    String lastDrawnSalary;
    List<String> skills;

    List<Certification> certs;

    @Version
    Long version;

    public static String getCollectionName() {
        return null;
    }
}
