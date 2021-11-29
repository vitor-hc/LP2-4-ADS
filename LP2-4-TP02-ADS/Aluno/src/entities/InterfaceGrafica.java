/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;

public class InterfaceGrafica implements ActionListener {
    
	private JFrame tela = new JFrame();
        //-----------------------------------------
	private JLabel label = new JLabel("Nome:");
	private JLabel label1 = new JLabel("Idade");
	private JLabel label2 = new JLabel("Endereço");
        //-----------------------------------------
        
       
	private JTextField text = new JTextField(10);
	private JTextField text1 = new JTextField(10);
	private JTextField text2 = new JTextField(10);
	private JButton button = new JButton();
	private JButton button1 = new JButton();
	private JButton button2 = new JButton();
	private JButton button3 = new JButton();
	private JPanel painel = new JPanel();
	private JPanel painel1 = new JPanel();
	private JPanel painel2 = new JPanel();
	private List<Aluno> alunos = new ArrayList<Aluno>();

	InterfaceGrafica(){
                //Formulario 400x180
		tela.setSize(400,180);
		tela.setLocation(200,200);
		tela.setTitle("TP02 - LP2I4");
		tela.add(painel);
		painel.setBackground(Color.LIGHT_GRAY);
		painel1.setBackground(Color.LIGHT_GRAY);
		painel2.setBackground(Color.LIGHT_GRAY);
		painel.add(painel1);
                //Painel com Grid layoout 3x2 hgap e vgap 10
		painel1.setLayout(new GridLayout(3,2,10,10));
		painel1.add(label);
		painel1.add(text);
		painel1.add(label1);
		painel1.add(text1);
		painel1.add(label2);
		painel1.add(text2);
		painel.add(painel2);
                //-----------------------------------------
                //Painel inferior com 4 botoes 
		button.setText("OK");
		button.addActionListener(this);
		button1.setText("Limpar");
		button1.addActionListener(this);
		button2.setText("Mostrar");
		button2.addActionListener(this);
		button3.setText("Sair");
		button3.addActionListener(this);
		painel2.add(button);
		painel2.add(button1);
		painel2.add(button2);
		painel2.add(button3);
		tela.setVisible(true);
		}
        //metodo limpar labels
	public void clean() {
		text.setText("");
		text1.setText("");
		text2.setText("");
	}
        //Metodo adicionar limpar mostrar e sair
	public void actionPerformed(ActionEvent e) {
		String x = e.getActionCommand();
		if("OK".equals(x)) {
			alunos.add(new Aluno(text2.getText(),Integer.parseInt(text1.getText()),text.getText()));
			clean();
		}
		if("Limpar".equals(x)) {
			clean();
		}
		
		if("Mostrar".equals(x)) {
		
                    String mensagem = "";
                        mensagem +="Resultado";
                        mensagem += "\n";
			for (Aluno usuario : alunos) {
                        
                       
			mensagem += "id: " +  usuario.getUuid() + "";
			mensagem += " Nome: " + usuario.getNome() + "";
			mensagem += "\n";
			}
                        
			JOptionPane.showMessageDialog(null, mensagem, "Mensagem",JOptionPane.INFORMATION_MESSAGE);
                       
                       
              
		}
		if("Sair".equals(x)) {
			tela.dispose();
		}
	}
	public static void main(String[]args) {
		InterfaceGrafica tela = new InterfaceGrafica();
	}
}