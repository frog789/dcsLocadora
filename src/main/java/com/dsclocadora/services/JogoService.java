/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsclocadora.services;

import com.dsclocadora.entities.Jogo;
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
@Stateless(name = "ejb/JogoService")
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class JogoService extends Service<Jogo> {
    
     @PostConstruct
    public void init() {
        super.setClasse(Jogo.class);
    }

    @Override
    public Jogo criar() {
        return new Jogo();
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Jogo> getItensPorCategoria(String nomeCategoria) {
        return super.consultarEntidades(new Object[] {nomeCategoria}, Jogo.ITEM_POR_CATEGORIA);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Jogo> getItensPorTitulo(String titulo) {
        return super.consultarEntidades(new Object[] {titulo}, Jogo.ITEM_POR_TITULO);
    }    
    
}
