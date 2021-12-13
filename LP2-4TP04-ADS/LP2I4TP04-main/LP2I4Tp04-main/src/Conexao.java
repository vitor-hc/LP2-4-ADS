

	import java.sql.*;
	import javax.swing.JOptionPane;

	public class Conexao {
	    private Connection Con = null;
	    private Statement Stmt = null;
	    private ResultSet Rs = null;
    	String erro = "";
	    
	    
	    public ResultSet rs() {
	        return Rs;
	    }
	    
	    public Conexao(){
	        try {
	            Con = DriverManager.getConnection("jdbc:sqlserver://VITOR;databaseName=TPJAVA","test","Vitor123");
	            
	            Stmt = Con.createStatement();
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, erro);
	        }
	    }
	    public void pesquisa(String x){        
	        try {
	            Rs = Stmt.executeQuery("select nome_func, sal_func, ds_cargo from tbfuncs inner join tbcargos on tbcargos.cd_cargo = tbfuncs.cod_cargo where nome_func like " + "'%" + x + "%';");
	            Rs.next();   
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, erro);
	        }        
	    }
	}
