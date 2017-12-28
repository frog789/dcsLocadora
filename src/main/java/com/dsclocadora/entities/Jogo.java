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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_JOGO")
@NamedQueries(
        {
            @NamedQuery(
                    name = Jogo.ITEM_POR_CATEGORIA,
                    query = "SELECT i FROM Jogo i, Categoria c WHERE c.nome like ?1 AND c MEMBER OF i.categorias"
            ),
            @NamedQuery(
                    name = Jogo.ITEM_POR_TITULO,
                    query = "SELECT i FROM Jogo i WHERE i.titulo like ?1"
            )
        }
)
public class Jogo implements Serializable {
    
    public static final String ITEM_POR_CATEGORIA = "ItemPorCategoria";
    public static final String ITEM_POR_TITULO = "ItemPorTitulo";

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "titulo", length = 60, nullable = false)
    private String titulo;

    @NotNull
    @Column(name = "quantidade_disponivel", length = 60)
    private int qtdDisponivel;

    @NotBlank
    @Column(name = "quantidade_jogadores", length = 60, nullable = false)
    private int qtdJogadores;

    @NotNull
    @Column(name = "tam_jogo", length = 60)
    private Double tamanhoGB;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private FaixaEtariaEnum classificacao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "games_audio", joinColumns = {
        @JoinColumn(name = "ID_GAME")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_AUDIO")})
    private Idioma audioIdioma;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "games_legenda", joinColumns = {
        @JoinColumn(name = "ID_GAME")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_LEGENDA")})
    private Idioma legendaIdioma;

    @NotBlank
    @Column(name = "nome_criador", length = 60, nullable = false)
    private String nomeCriador;

    @NotBlank
    @Column(name = "produtora", length = 60, nullable = false)
    private Produtora produtora;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "games_categoria", joinColumns = {
        @JoinColumn(name = "ID_GAME")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_CATEGORIA")})
    private List<Categoria> categorias;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_lancamento")
    private Date dtLancamento;

    @NotBlank
    @Column(name = "valor_jogo", length = 60, nullable = false)
    private Double valorJogo;

    @NotBlank
    @Column(name = "valor_locacao", length = 60, nullable = false)
    private Double valorLocacao;

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

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }

    public int getQtdJogadores() {
        return qtdJogadores;
    }

    public void setQtdJogadores(int qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }

    public Double getTamanhoGB() {
        return tamanhoGB;
    }

    public void setTamanhoGB(Double tamanhoGB) {
        this.tamanhoGB = tamanhoGB;
    }

    public FaixaEtariaEnum getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(FaixaEtariaEnum classificacao) {
        this.classificacao = classificacao;
    }

    public Idioma getAudioIdioma() {
        return audioIdioma;
    }

    public void setAudioIdioma(Idioma audioIdioma) {
        this.audioIdioma = audioIdioma;
    }

    public Idioma getLegendaIdioma() {
        return legendaIdioma;
    }

    public void setLegendaIdioma(Idioma legendaIdioma) {
        this.legendaIdioma = legendaIdioma;
    }

    public String getCriador() {
        return nomeCriador;
    }

    public void setCriador(String criador) {
        this.nomeCriador = criador;
    }

    public Produtora getProdutora() {
        return produtora;
    }

    public void setProdutora(Produtora produtora) {
        this.produtora = produtora;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Date getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public Double getValorJogo() {
        return valorJogo;
    }

    public void setValorJogo(Double valorJogo) {
        this.valorJogo = valorJogo;
    }

    public Double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(Double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Jogo)) {
            return false;
        }
        Jogo other = (Jogo) obj;
        if (getId() == null) {
            if (other.getId() != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
