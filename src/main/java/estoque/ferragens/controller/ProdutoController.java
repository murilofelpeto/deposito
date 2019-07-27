package estoque.ferragens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import estoque.ferragens.model.Produto;
import estoque.ferragens.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepo;

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		List<Produto> produtos = produtoRepo.findAll();
		return (produtos.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(produtos, HttpStatus.OK);
	}

	@GetMapping("/categoria")
	public ResponseEntity<List<Produto>> getByCategoria(
			@RequestParam(value = "categoria", required = true) String categoria) {

		List<Produto> produtos = produtoRepo.findByCategoriaNomeCategoria(categoria);
		return (produtos.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(produtos, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Produto> postProduto(@RequestBody Produto requestBody) {
		Produto produto = new Produto();
		produto.setCategoria(requestBody.getCategoria());
		produto.setDescricao(requestBody.getDescricao());
		produto.setNomeProduto(requestBody.getNomeProduto());
		produto.setSku(requestBody.getSku());
		produto.setUnidade(requestBody.getUnidade());
		produtoRepo.save(requestBody);
		return new ResponseEntity<Produto>(HttpStatus.CREATED);
	}
}
