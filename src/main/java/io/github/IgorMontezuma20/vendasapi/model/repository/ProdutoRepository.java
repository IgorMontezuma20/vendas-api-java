package io.github.IgorMontezuma20.vendasapi.model.repository;

import io.github.IgorMontezuma20.vendasapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {


}
