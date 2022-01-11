	import java.sql.*;
	import javax.swing.JOptionPane;

	public class Conexao {
	    private Connection Con = null;
	    private Statement Stmt = null;
	    
	    public Conexao(){
	        try {
	            Con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=AulaJava","sa","123");
	            Stmt = Con.createStatement();
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, "ERRO VERIFIQUE A CONEXÃO COM O BANCO DE DADOS");
	        }
	    }
	    public void incluir(String nome, int idade, float peso, float altura, String objetivo){        
	        try {
	            Stmt.executeUpdate("insert into ALUNO (nome, idade, peso, altura, objetivo)values("+"'"+ nome +"'"+","+idade+","+peso+","+altura+",'"+objetivo+"')");
	            JOptionPane.showMessageDialog(null, "ENVIADO");
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, "ERRO: OS DADOS NÃO FORAM ENVIADOS PARA O BANCO DE DADOS.");
	        }        
	    }
	}
