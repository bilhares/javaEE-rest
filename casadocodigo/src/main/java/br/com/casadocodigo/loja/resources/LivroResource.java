package br.com.casadocodigo.loja.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.casadocodigo.loja.dao.AutorDao;
import br.com.casadocodigo.loja.dao.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

@Path("/livros")
public class LivroResource {

	@Inject
	private LivroDao livroDao;

	@Inject
	private AutorDao autorDao;

	@GET
	@Produces("application/json")
	public List<Livro> listar() {
		List<Livro> livros = livroDao.listar();
		return livros;
	}

	@POST
	@Consumes("application/json")
	public void salvar(Livro livro) {
		livroDao.salvar(livro);
	}
}
