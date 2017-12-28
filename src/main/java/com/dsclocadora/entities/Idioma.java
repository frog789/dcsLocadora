package com.dsclocadora.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "TB_IDIOMA")
@NamedQueries(
        {
            @NamedQuery(
                    name = Idioma.ITEM_POR_NOMEIDIOMA,
                    query = "SELECT i FROM Idioma i WHERE i.nome_idioma like ?1"
            ),
                @NamedQuery(
                    name = Idioma.ITEM_POR_ID,
                    query = "SELECT i FROM Idioma i WHERE i.id like ?1"
            )
        }
)
public class Idioma {

     public static final String ITEM_POR_NOMEIDIOMA = "ItemPorNomeIdioma";
     public static final String ITEM_POR_ID = "ItemPorId";
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome_idioma", length = 60, nullable = false)
    private String name;

}
