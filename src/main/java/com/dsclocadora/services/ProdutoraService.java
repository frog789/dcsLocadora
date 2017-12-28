package com.dsclocadora.services;

import com.dsclocadora.entities.Idioma;
import com.dsclocadora.entities.Produtora;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;

/**
 *
 * @author Rapha
 */
@Stateless(name = "ejb/ProdutoraService")
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class ProdutoraService extends Service<Produtora> {
    
        @PostConstruct
    public void init() {
        super.setClasse(Produtora.class);
    }

    @Override
    public Produtora criar() {
        return new Produtora();
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Produtora> getItensPorNomeIdioma(String nomeProdutora) {
        return super.consultarEntidades(new Object[] {nomeProdutora}, Produtora.PRODUTORA_POR_NOME);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Produtora> getItensPorId(Long id) {
        return super.consultarEntidades(new Object[] {id}, Produtora.PRODUTORA_POR_ID);
    }

    
}
