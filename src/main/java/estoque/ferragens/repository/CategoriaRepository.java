package estoque.ferragens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import estoque.ferragens.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, String>{

}
