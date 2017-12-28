package com.dsclocadora.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Jogo.class)
public abstract class Jogo_ {

	public static volatile SingularAttribute<Jogo, Double> valorJogo;
	public static volatile SingularAttribute<Jogo, String> nomeCriador;
	public static volatile SingularAttribute<Jogo, Integer> qtdJogadores;
	public static volatile ListAttribute<Jogo, Jogo> categorias;
	public static volatile SingularAttribute<Jogo, Double> valorLocacao;
	public static volatile SingularAttribute<Jogo, String> titulo;
	public static volatile SingularAttribute<Jogo, FaixaEtariaEnum> classificacao;
	public static volatile SingularAttribute<Jogo, Long> id;
	public static volatile SingularAttribute<Jogo, Date> dtLancamento;
	public static volatile SingularAttribute<Jogo, Integer> qtdDisponivel;
	public static volatile SingularAttribute<Jogo, Produtora> produtora;
	public static volatile SingularAttribute<Jogo, Double> tamanhoGB;

}

