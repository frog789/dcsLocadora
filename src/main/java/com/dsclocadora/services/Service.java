package com.dsclocadora.services;

import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Rapha
 */
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public abstract class Service<T> {
    
    @PersistenceContext(name = "dscLocadora", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em;
    protected Class<T> classe;
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    protected void setClasse(@NotNull Class<T> classe) {
        this.classe = classe;
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public abstract T criar();

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public boolean existe(@NotNull T entidade) {
        return true;
    }
    
     public void persistir(@Valid T entidade) {
        if (!existe(entidade)) {
            em.persist(entidade);
        }
    }

    public void atualizar(@Valid T entidade) {
        if (existe(entidade)) {
            em.merge(entidade);
            em.flush();
        }
    }
    
     @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public T consultarPorId(@NotNull Long id) {
        return em.find(classe, id);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected T consultarEntidade(Object[] parametros, String nomeQuery) {
        TypedQuery<T> query = em.createNamedQuery(nomeQuery, classe);

        int i = 1;
        for (Object parametro : parametros) {
            query.setParameter(i++, parametro);
        }

        return query.getSingleResult();
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<T> consultarEntidades(Object[] parametros, String nomeQuery) {
        TypedQuery<T> query = em.createNamedQuery(nomeQuery, classe);

        int i = 1;
        for (Object parametro : parametros) {
            query.setParameter(i++, parametro);
        }

        return query.getResultList();
    }
    
}
