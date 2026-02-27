package com.org.sistemaAgend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_agendamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @NotNull(message = "Cliente é obrigatório")
    private Cliente cliente;

    @NotNull(message = "Data é obrigatória")
    @Future(message = "A data deve ser futura")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @NotNull(message = "Horário é obrigatório")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horario;

    @NotNull(message = "Serviço é obrigatório")
    private String servico;

    private String observação;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status = StatusAgendamento.AGUARDANDO;

    private LocalDate dataCriacao = LocalDate.now();
}
