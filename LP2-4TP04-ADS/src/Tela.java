import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Tela implements ActionListener {
	private Conexao conexao = new Conexao();
	private JFrame tela = new JFrame();
	private JLabel labelNome1 = new JLabel("Nome:");
	private JLabel labelNome2 = new JLabel("Nome:");
	private JLabel labelSalario = new JLabel("Salário");
	private JLabel labelCargo = new JLabel("Cargo");
	private JLabel labelclean = new JLabel("");
	private JTextField textoNome1 = new JTextField(10);
	private JTextField textoNome2 = new JTextField(10);
	private JTextField textoSalario = new JTextField(10);
	private JTextField textoCargo = new JTextField(10);
	private JButton buttonPesquisar = new JButton();
	private JButton buttonAnterior = new JButton();
	private JButton buttonProximo = new JButton();
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	String erro = "";
	private void view(){
        try {                
        	String nome2 = conexao.rs().getString("nome_func");
        	float salario = conexao.rs().getFloat("sal_func");
        	String cargo = conexao.rs().getString("ds_cargo");
                textoNome2.setText(""+nome2);
                textoSalario.setText(""+salario);
                textoCargo.setText(""+cargo);
            } catch (SQLException e) {
            	JOptionPane.showMessageDialog(null, "");
            }
    }
	
	Tela(){
		tela.setSize(400,280);
		tela.setLocation(200,200);
		tela.setTitle("Tp04 - Lp2I4");
		tela.add(panel);
		panel.add(panel1);
		panel1.setLayout(new GridLayout(3,2,10,10));
		panel1.add(labelNome1);
		panel1.add(textoNome1);
		panel1.add(labelclean);
		panel1.add(buttonPesquisar);
		buttonPesquisar.setText("Pesquisar");
		buttonPesquisar.addActionListener(this);
		panel.add(panel2);
		panel2.setLayout(new GridLayout(3,2,10,10));
		panel2.add(labelNome2);
		panel2.add(textoNome2);
		textoNome2.setEditable(false);
		panel2.add(labelSalario);
		panel2.add(textoSalario);
		textoSalario.setEditable(false);
		panel2.add(labelCargo);
		panel2.add(textoCargo);
		textoCargo.setEditable(false);
		panel.add(panel3);
		panel3.add(buttonAnterior);
		buttonAnterior.setText("Anterior");
		buttonAnterior.addActionListener(this);
		panel3.add(buttonProximo);
		buttonProximo.setText("Proximo");
		buttonProximo.addActionListener(this);
		tela.setVisible(true);
		}
	public void actionPerformed(ActionEvent e) {
		String x = e.getActionCommand();
		 conexao.pesquisa(textoNome1.getText());
		if("Pesquisar".equals(x)) {
			 if(conexao.rs() != null){
				 view();
			 }
		        else
		        	JOptionPane.showMessageDialog(null, erro);
		}
		if("Anterior".equals(x)) {
			try {
				conexao.rs().previous();
	            view();
	        } catch (SQLException e1) {
	        	JOptionPane.showMessageDialog(null, "Não tem cadastro anterior");
	        }
		}
		
		if("Proximo".equals(x)) {
			try {
	            conexao.rs().next();
	            view();
	        } catch (SQLException e2) {
	        	JOptionPane.showMessageDialog(null, "Não há proximo cadastro");
	        }
		}
	}	
	
	public static void main(String[]args) {
		Tela tela = new Tela();
	}
}



  