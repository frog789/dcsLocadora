package com.dsclocadora.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import com.dsclocadora.entities.Categoria;

@Entity
@Table (name = "TB_Jogo")
public class Jogo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "titulo", length = 60, nullable = false)
	private String titulo;
	
	@NotBlank
	@Column(name = "quantidade_disponivel", length = 60, nullable = false)
	private int qtdDisponivel;
	
	@NotBlank
	@Column(name = "quantidade_jogadores", length = 60, nullable = false)
	private int qtdJogadores;
	
	@NotBlank
	@Column(name = "tam_jogo", length = 60, nullable = false)
	private Double tamanhoGB;
	
	@NotBlank
	@Column(name = "classificacao_etaria", length = 60, nullable = false)
	private FaixaEtariaEnum classificacao;
	
	@NotBlank
	@Column(name = "audio_idioma", length = 60, nullable = false)
	private Idioma audioIdioma;
	
	@NotBlank
	@Column(name = "tam_jogo", length = 60, nullable = false)
	private Idioma legendaIdioma;
	
	@NotBlank
	@Column(name = "nome_criador", length = 60, nullable = false)
	private String criador;
	
	@NotBlank
	@Column(name = "produtora", length = 60, nullable = false)
	private String produtora;

	@NotNull
	@Column(name = "dt_lancamento", length = 32, nullable = false)
	protected Date dtLancamento;
	
	@Enumerated (EnumType.STRING)
	private FaixaEtariaEnum pegRating;
	
	@ManyToMany (fetch = FetchType.LAZY)
	@JoinTable(name = "games_categoria", joinColumns = {
			@JoinColumn(name = "ID_GAME")},
			inverseJoinColumns = {
					@JoinColumn(name = "ID_CATEGORIA")})
	private List<Jogo> categorias;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_aluguel")
	protected Date dtAluguel;	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCriador() {
		return criador;
	}

	public void setCriador(String criador) {
		this.criador = criador;
	}

	public Double getTamanhoGB() {
		return tamanhoGB;
	}

	public void setTamanhoGB(Double tamanhoGB) {
		this.tamanhoGB = tamanhoGB;
	}

	public String getProdutora() {
		return produtora;
	}

	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}

	public Date getDtLancamento() {
		return dtLancamento;
	}

	public void setDtLancamento(Date dtLancamento) {
		this.dtLancamento = dtLancamento;
	}

	public FaixaEtariaEnum getPegRating() {
		return pegRating;
	}

	public void setPegRating(FaixaEtariaEnum pegRating) {
		this.pegRating = pegRating;
	}

	public List<Jogo> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Jogo> categorias) {
		this.categorias = categorias;
	}

	public Date getDtAluguel() {
		return dtAluguel;
	}

	public void setDtAluguel(Date dtAluguel) {
		this.dtAluguel = dtAluguel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Jogo))
			return false;
		Jogo other = (Jogo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
