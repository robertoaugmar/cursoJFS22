package br.com.bob.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

@ManagedBean
//@RequestScoped
@ViewScoped
public class PrimeiroBean {
	
	private String nome;
	private String sobrenome;
	
	private HtmlCommandButton hcb ; 
	
	private String nomeCompleto;
	
	private List<String> nomes = new ArrayList<String>();
	
	public List<String> getNomes() {
		return nomes;
	}
	
	public String mostrarNome() {
		nomeCompleto = nome + " " + sobrenome;
		nomes.add(nome);
		if(nomes.size() > 2) {
			hcb.setDisabled(true);
			return "paginanavegada";
			
		}
		return "";
	}
	

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}

	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public HtmlCommandButton getHcb() {
		return hcb;
	}

	public void setHcb(HtmlCommandButton hcb) {
		this.hcb = hcb;
	}
	

}
