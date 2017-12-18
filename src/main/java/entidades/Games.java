package entidades;

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

import entidades.Categoria;

@Entity
@Table (name = "TB_GAMES")
public class Games implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "nome_game", length = 60, nullable = false)
	private String name;
	
	@NotBlank
	@Column(name = "nome_criador", length = 60, nullable = false)
	private String criador;
	
	@NotBlank
	@Column(name = "empresa_desenvolvedor", length = 60, nullable = false)
	private String empDesemvolvedor;

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
	private List<Games> categorias;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_aluguel")
	protected Date dtAluguel;
	
	
	
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
		if (!(obj instanceof Games))
			return false;
		Games other = (Games) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
