package estoque.ferragens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import estoque.ferragens.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findByCategoriaNomeCategoria(@Param("categoria") String categoria);
}
