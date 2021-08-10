/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gustavo
 */
public class ConnectionFactory {
    
    private Connection connection;
    
    private static final String URL_CONEXAO = "jdbc:mysql://localhost:13306/agenda";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public ConnectionFactory() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao Conectar com o Banco de Dados: " + e.getMessage());
        }
    }
    
    public static ConnectionFactory getInstance() {
        return new ConnectionFactory();
    }
    
    public Connection getConnection() {
        return connection;
    }
    
}
