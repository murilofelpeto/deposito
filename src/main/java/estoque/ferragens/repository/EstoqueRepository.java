package estoque.ferragens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import estoque.ferragens.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
