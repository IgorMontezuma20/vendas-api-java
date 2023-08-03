package io.github.IgorMontezuma20.vendasapi.model.repository;

import io.github.IgorMontezuma20.vendasapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
