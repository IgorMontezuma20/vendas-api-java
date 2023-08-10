package io.github.IgorMontezuma20.vendasapi.model.repository;

import io.github.IgorMontezuma20.vendasapi.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository  extends JpaRepository<SaleItem, Long> {
}
