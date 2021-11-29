import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex2v3 implements ActionListener {

	 private Pessoa pessoas = new Pessoa();
	    
	    private JFrame tela = new JFrame();
		private JLabel labelNum = new JLabel("Numero:");
		private JLabel labelNome = new JLabel("Nome");
		private JLabel labelSexo = new JLabel("Sexo");
		private JLabel labelIdade = new JLabel("Idade");
		private JLabel labelclean = new JLabel("");
		private JLabel labelclean1 = new JLabel("");
		private JTextField textoNum = new JTextField(10);
		private JTextField textoNome = new JTextField(10);
		private JTextField textoIdade = new JTextField(10);
		private JButton buttonOk = new JButton();
		private JButton buttonLimpar = new JButton();
		private JButton buttonMostrar = new JButton();
		private JButton buttonSair = new JButton();
		private JPanel panel = new JPanel();
		private JPanel panel1 = new JPanel();
		private JPanel panel2 = new JPanel();
		private JRadioButton jRadioButtonF = new JRadioButton();
		private JRadioButton jRadioButtonM = new JRadioButton();
		private ButtonGroup buttonGroup = new ButtonGroup();
		private ButtonGroup buttonGroup1 = new ButtonGroup();
		
		Ex2v3() {

	    	tela.setSize(400,230);
			tela.setLocation(200,200);
			tela.setTitle("Tp03 - Lp2I4");
			tela.add(panel);
			panel.setBackground(Color.LIGHT_GRAY);
			panel1.setBackground(Color.LIGHT_GRAY);
			panel2.setBackground(Color.LIGHT_GRAY);
			panel.add(panel1);
			panel1.setLayout(new GridLayout(4,3,10,10));
			panel1.add(labelNum);
			panel1.add(textoNum);
			textoNum.setEditable(false);
			panel1.add(labelclean);
			panel1.add(labelNome);
			panel1.add(textoNome);
			panel1.add(labelclean1);
			panel1.add(labelSexo);
			panel1.add(jRadioButtonF);
			panel1.add(jRadioButtonM);
			buttonGroup.add(jRadioButtonF);
			jRadioButtonF.setText("Feminino");
			buttonGroup1.add(jRadioButtonM);
			jRadioButtonM.setText("Masculino");
			panel1.add(labelIdade);
			panel1.add(textoIdade);
			panel.add(panel2);
			buttonOk.setText("OK");
			buttonOk.addActionListener(this);
			buttonLimpar.setText("Limpar");
			buttonLimpar.addActionListener(this);
			buttonMostrar.setText("Mostrar");
			buttonMostrar.addActionListener(this);
			buttonSair.setText("Sair");
			buttonSair.addActionListener(this);
			panel2.add(buttonOk);
			panel2.add(buttonLimpar);
			panel2.add(buttonMostrar);
			panel2.add(buttonSair);
			tela.setVisible(true);
			}
		public void clean() {
			textoNum.setText("");
			textoNome.setText("");
			textoIdade.setText("");
			buttonGroup.clearSelection();
		}
		public void actionPerformed(ActionEvent e) {
			String x = e.getActionCommand(); 
			if("OK".equals(x)) {
				 char c;
			        
			        if (jRadioButtonF.isSelected())
			            c = 'F';
			        else
			            c = 'M';
				pessoas = (new Pessoa(textoNome.getText(),c,Integer.parseInt(textoIdade.getText())));
				clean();
			}
			if("Limpar".equals(x)) {
				clean();
			}
			
			if("Mostrar".equals(x)) {
				int i;
				textoNum.setText(Integer.toString(pessoas.getKp()));
				textoNome.setText(pessoas.getNome());
		        textoIdade.setText(Integer.toString(pessoas.getIdade()));
		        if(pessoas.getSexo() == 'F')
		        	jRadioButtonF.isSelected();
		        else
		        	jRadioButtonM.isSelected();
			}
			if("Sair".equals(x)) {
				tela.dispose();
			}
		}
		public static void main(String[]args) {
			Ex2v3 t = new Ex2v3();
		}	
}