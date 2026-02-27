package com.org.sistemaAgend.repository;

import com.org.sistemaAgend.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    boolean existsByDataAndHorario(LocalDate data, LocalTime horario);

    //Busca agendamentos por data
    List<Agendamento> findByDataOrderByHorario(LocalDate data);

    //Busca agendamentos por cliente
    List<Agendamento> findByClienteIdOrderByDataDescHorarioDesc(Long clienteId);

    // Conta quantos agendamentos existem em um determinado horário
    @Query("SELECT COUNT(a) FROM Agendamento a WHERE a.data = :data AND a.horario = :horario AND a.status != 'CANCELADO'")
    int countAgendamentosAtivos(@Param("data") LocalDate data, @Param("horario") LocalTime horario);

    @Query("SELECT a.horario FROM Agendamento a WHERE a.data = :data AND a.status != 'CANCELADO'")
    List<LocalTime> findHorariosOcupados(@Param("data") LocalDate data);
}
