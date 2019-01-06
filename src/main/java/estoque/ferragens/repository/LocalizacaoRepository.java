package estoque.ferragens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import estoque.ferragens.model.Localizacao;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, String>{

}
