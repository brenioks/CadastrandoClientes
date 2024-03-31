package pacote.cadastrandoclientes;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {   
    private final String dadosClientes;
    
    public Conexao(){
      StringBuilder dados = new StringBuilder();
      
      try{
        String url = "jdbc:mysql://localhost:3306/cadastroclientes";
        Connection conexao = DriverManager.getConnection(url,"root","");
        ResultSet tabelaClientes = conexao.createStatement().executeQuery("SELECT * FROM clientes");
        
        int tamanho = 1;
        
        while(tabelaClientes.next()){
            String nomes = tabelaClientes.getString("nome");
            String sobreNomes = tabelaClientes.getString("sobrenome");
            String emails = tabelaClientes.getString("email");          
            
            dados.append(tamanho).append("\n").append("Nome: ").append(nomes).append(" ").append(sobreNomes).append("\n").append("Email: ").append(emails).append("\n").append("\n");
        
            tamanho++;
        }
        
        }catch(SQLException ex){
            System.out.println("Conexao com MySql nao encontrada" + ex.getMessage());
        }  
      
      dadosClientes = dados.toString();
      
    }
    
    public String puxarDadosMysql(){
        return dadosClientes;
    }
    
    public void cadastrandoCliente(String nome, String sobrenome, String email){
        try{
            String url = "jdbc:mysql://localhost:3306/cadastroclientes";
            Connection conexao = DriverManager.getConnection(url,"root","");

            String inserirDado = "INSERT INTO clientes (nome, sobrenome, email) VALUES (?, ?, ?)";
            PreparedStatement declaracao = conexao.prepareStatement(inserirDado);

            declaracao.setString(1,nome);
            declaracao.setString(2,sobrenome);
            declaracao.setString(3,email);

            declaracao.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso, confira o relatorio");
            System.out.println("Cliente inserido com sucesso, confira o relatorio");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente" + ex.getMessage());
            System.out.println("Erro ao cadastrar cliente" + ex.getMessage());
            
        }  
    }
    
}
