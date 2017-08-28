package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.casadocodigo.loja.dao.AutorDao;
import br.com.casadocodigo.loja.dao.LivroDao;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

//CDI
@Named(value = "adminLivrosBean")
@RequestScoped
public class AdminLivrosBean {

	private Livro livro = new Livro();

	private List<Integer> autoresId = new ArrayList<>();

	@Inject
	private LivroDao livroDao;

	@Inject
	private AutorDao autorDao;

	public String salvar() {

		for (Integer autorID : autoresId) {
			livro.getAutores().add(new Autor(autorID));
		}

		livroDao.salvar(livro);
		System.out.println("Livro salvo com sucesso!");

		return "/livros/lista?faces-redirect=true";
	}

	public List<Autor> getAutores() {
		return autorDao.listar();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Integer> getAutoresId() {
		return autoresId;
	}

	public void setAutoresId(List<Integer> autoresId) {
		this.autoresId = autoresId;
	}

}
