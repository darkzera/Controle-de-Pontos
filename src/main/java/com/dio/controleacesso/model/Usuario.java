package com.dio.controleacesso.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity

@Audited
// Qdo colocamos Audited numa table/class, TODAS as outras classes ligadas a ela tambem precisam receber a notacao
public class Usuario {

    @Id
    private Long id;
    @ManyToOne
    private CategoriaUsuario categoriaUser;
    private String nomeUser;
    @ManyToOne
    private Empresa empresa;
    @ManyToOne
    private NivelAcesso nivelAcesso;
    @ManyToOne
    private JornadaTrabalho jornadaTrabalho;
    private BigDecimal tolerancia;
    private LocalDateTime inicio;
    private LocalDateTime fim;



}
