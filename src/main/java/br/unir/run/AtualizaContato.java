/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unir.run;

import br.unir.dao.ContatoDao;
import br.unir.model.Contato;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class AtualizaContato {

    public static void main(String[] args) {
        ContatoDao contatoDao = new ContatoDao();

        Contato contato = contatoDao.contatoPeloId(1);

        contato.setEmail("gustavo.tadei@email.com");
        contato.setObservacao("Email do contato atualizado");
        
        contatoDao.atualizar(contato);
        
        ////////////////////////////////////////////////////////////////////////
        
        List<Contato> listaContato = contatoDao.listar();
        System.out.println("Lista de Contatos cadastrados:");
        
        for (Contato c : listaContato) {
            System.out.println(c.toString());
        }
    }

}
