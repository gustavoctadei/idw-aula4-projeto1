/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unir.dao;

import br.unir.model.Contato;
import br.unir.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class ContatoDao {
    
    public void salvar(Contato contato) {
        try {
            Connection conexao = ConnectionFactory.getInstance().getConnection();
            
            String sql = "insert into contato(nome, telefone, email, data_cadastro, observacao, cpf) values(?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getTelefone());
            ps.setString(3, contato.getEmail());
            ps.setDate(4, contato.getDataCadastro());
            ps.setString(5, contato.getObservacao());
            ps.setString(6, contato.getCpf());
            
            ps.executeUpdate();
            
            ps.close();
            conexao.close();
            
        } catch(SQLException e) {
            System.out.println("Erro ao salvar contato: " + e.getMessage());
        }
    }
    
    public void atualizar(Contato contato) {
        try {
            Connection conexao = ConnectionFactory.getInstance().getConnection();
            
            String sql = "update contato set nome = ?, telefone = ?, email = ?, observacao = ?, cpf = ? where id_contato = ?";
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getTelefone());
            ps.setString(3, contato.getEmail());
            ps.setString(4, contato.getObservacao());
            ps.setString(5, contato.getCpf());
            ps.setInt(6, contato.getIdContato());
            
            ps.executeUpdate();
            
            ps.close();
            conexao.close();
            
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar contato: " + e.getMessage());
        }
    }
    
    public void excluir(Contato contato) {
        try {
            Connection conexao = ConnectionFactory.getInstance().getConnection();
            
            String sql = "delete from contato where id_contato = ?";
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, contato.getIdContato());
            
            ps.executeUpdate();
            
            ps.close();
            conexao.close();
            
        } catch (SQLException e) {
            System.out.println("Erro ao excluir contato: " + e.getMessage());
        }
    }
    
    public Contato contatoPeloId(Integer idContato) {
        try {
            Connection conexao = ConnectionFactory.getInstance().getConnection();
            ResultSet rs = null;
            Contato contato = null;
            
            String sql = "select * from contato where id_contato = ?";
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idContato);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                contato = new Contato();
                contato.setIdContato(rs.getInt("id_contato"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setEmail(rs.getString("email"));
                contato.setDataCadastro(rs.getDate("data_cadastro"));
                contato.setObservacao(rs.getString("observacao"));
                contato.setCpf(rs.getString("cpf"));
            }
            
            ps.close();
            conexao.close();
            
            return contato;
            
        } catch (SQLException e) {
            System.out.println("Erro ao buscar contato: " + e.getMessage());
            return null;
        }
    }
    
    public List<Contato> listar() {
        try {
            Connection conexao = ConnectionFactory.getInstance().getConnection();
            ResultSet rs = null;
            Contato contato = null;
            List<Contato> listaContato = new ArrayList<>();
            
            String sql = "select * from contato";
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                contato = new Contato();
                contato.setIdContato(rs.getInt("id_contato"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setEmail(rs.getString("email"));
                contato.setDataCadastro(rs.getDate("data_cadastro"));
                contato.setObservacao(rs.getString("observacao"));
                contato.setCpf(rs.getString("cpf"));
                
                listaContato.add(contato);
            }
            
            ps.close();
            conexao.close();
            
            return listaContato;
            
        } catch (SQLException e) {
            System.out.println("Erro ao listar contatos: " + e.getMessage());
            return null;
        }
    }
    
    public void excluirTodos() {
        try {
            Connection conexao = ConnectionFactory.getInstance().getConnection();
            
            String sql = "delete from contato";
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.executeUpdate();
            
            ps.close();
            conexao.close();
            
        } catch (SQLException e) {
            System.out.println("Erro ao excluir contatos: " + e.getMessage());
        }
    }
    
}
