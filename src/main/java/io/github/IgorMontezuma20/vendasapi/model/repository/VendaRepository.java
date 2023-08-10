package io.github.IgorMontezuma20.vendasapi.model.repository;

import io.github.IgorMontezuma20.vendasapi.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
