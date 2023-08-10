package io.github.IgorMontezuma20.vendasapi.model.repository;

import io.github.IgorMontezuma20.vendasapi.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
