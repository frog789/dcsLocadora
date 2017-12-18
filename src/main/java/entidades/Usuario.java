package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table (name = "TB_USUARIO")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 60)
	@Column(name = "email", nullable = false)
	private String email;
	
	@NotNull
	@Size(max = 32)
	@Column(name = "pass",nullable = false)
    private String pass;
	
	@NotNull
    @CPF
    @Column(name = "cpf")
    protected String cpf;

	@NotBlank
	@Column(name = "nome_usuario", length = 60, nullable = false)
	private String name;

	@NotNull
	@Column(name = "data_nacimento", length = 32, nullable = false)
	protected Date dataNascimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao")
	protected Date createdUser;
	
	@ElementCollection
	@CollectionTable(name = "tb_telefone", joinColumns = @JoinColumn(name = "ID_USUARIO", nullable = false))
	@Column(name = "telefone")
	private Collection<String> telefones;
	
	
	public Collection<String> getTelefones(){
		return telefones;
	}
	
	public void setTelefones(String telefone) {
		if(telefone == null) {
			telefones = new HashSet();
		}
		telefones.add(telefone);
	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    
    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

//	public void setTelefones(Collection<String> telefones) {
//		this.telefones = telefones;
//	}

	public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(Date createdUser) {
        this.createdUser = createdUser;
    }
    
    public void persistUsuario() {
    	
    	try {
    		
    	} catch (Exception e) {
    		
		}
    	
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
