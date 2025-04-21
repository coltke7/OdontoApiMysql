package com.api.odonto.repositories;


import com.api.odonto.models.Procedimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProcedimentosRepository extends JpaRepository<Procedimentos,Long> {
    Optional<Procedimentos> findById(Long id);
    List<Procedimentos> findAllByHistorico_Id(Long id);
}
