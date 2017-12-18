package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_CATEGORIA")
@NamedQueries({
		@NamedQuery(name = "Categoria.PorNome", query = "SELECT c FROM Categoria c WHERE c.nomeCategoria LIKE :nome ORDER BY c.id") })
public class Categoria implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "nome_categoria", length = 60)
	private String nomeCategoria;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID")
	private Categoria mae;

	@OneToMany(mappedBy = "mae", orphanRemoval = true)
	private List<Categoria> filhas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Categoria getMae() {
		return mae;
	}

	public void setMae(Categoria mae) {
		this.mae = mae;
	}

	public List<Categoria> getFilhas() {
		return filhas;
	}

	public void setFilhas(List<Categoria> filhas) {
		this.filhas = filhas;
	}

}
