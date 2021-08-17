package br.com.mesttra.medicaldep.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long playerId;

    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate admissionDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate estimatedReleaseDate;


}
