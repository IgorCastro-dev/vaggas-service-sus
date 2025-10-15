package org.sus.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vaga")
public class VagaEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "vaga_gen",sequenceName = "vaga_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vaga_gen")
    private Long id;

    @Column(name = "unidade_id")
    private Long unidadeId;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "horario_inicio")
    private LocalTime horarioInicio;

    @Column(name = "horario_fim")
    private LocalTime horarioFim;
}
