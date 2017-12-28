package com.dsclocadora.services;

import com.dsclocadora.entities.Jogo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import com.dsclocadora.entities.Idioma;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
/**
 *
 * @author Rapha
 */
@Stateless(name = "ejb/IdiomaService")
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class IdiomaService extends Service<Idioma>{
    
    @PostConstruct
    public void init() {
        super.setClasse(Idioma.class);
    }

    @Override
    public Idioma criar() {
        return new Idioma();
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Idioma> getItensPorNomeIdioma(String nomeIdioma) {
        return super.consultarEntidades(new Object[] {nomeIdioma}, Idioma.ITEM_POR_NOMEIDIOMA);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Idioma> getItensPorId(Long id) {
        return super.consultarEntidades(new Object[] {id}, Idioma.ITEM_POR_ID);
    }

    
    
}
