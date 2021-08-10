/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import dao.ContatoDao;

/**
 *
 * @author gustavo
 */
public class ExcluirTodosContatos {
    
    public static void main(String[] args) {
        ContatoDao contatoDao = new ContatoDao();
        
        contatoDao.excluirTodos();
    }
    
}
