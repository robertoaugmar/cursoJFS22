package br.com.bob.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.bob.dao.DaoGenerico;
import br.com.bob.entidades.Pessoa;

@ManagedBean
@ViewScoped
public class PessoaBean {

	private Pessoa pessoa = new Pessoa();
	private DaoGenerico<Pessoa> dao = new DaoGenerico<Pessoa>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	

	public String salvar() {

		pessoa = dao.merge(pessoa);
		// pessoa=new Pessoa();
		carregarPessoas();
		return "";

	}

	public String delete() {

		//dao.deletePorId(pessoa); // ok funciona 
		dao.delete(pessoa);   // ok funciona 
		pessoa=new Pessoa();
		carregarPessoas();
		return "";

	}

	public String novo() {

		pessoa = new Pessoa();
		return "";

	}
	
	@PostConstruct
	public void carregarPessoas() {
		
		pessoas = dao.getListEntity(Pessoa.class);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

}
