package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.AlunoController;
import model.Aluno;
import model.Data;

public class AlunoView {

	private static JFrame janela;
	private static JButton cadastrar;
	private static JButton cancelar;
	private static JTextField campoMatricula;
	private static JTextField campoNome;
	private static JTextField campoDatanascimento;
	private static JTextField campoSexo;

	public AlunoView() {
		iniciaGui();
	}

	public void iniciaGui() {

		// Dados da tela
		janela = new JFrame("Cadastrar novo aluno.");

		// Especs da tela
		janela.setSize(1000, 700);
		janela.setVisible(true);
		janela.getContentPane().setLayout(null);
		janela.setLocationRelativeTo(null);

		// Dados do aluno
		// field
		campoMatricula = new JTextField();
		campoMatricula.setBounds(100, 42, 350, 20);
		// ---------------------------------------
		JLabel lblMatricula = new JLabel();
		lblMatricula.setText("Matricula: ");
		lblMatricula.setBounds(10, 40, 80, 20);

		// field
		campoNome = new JTextField();
		campoNome.setBounds(100, 74, 350, 20);
		// ---------------------------------------
		JLabel lblNome = new JLabel();
		lblNome.setText("Nome: ");
		lblNome.setBounds(10, 70, 80, 30);

		// field
		campoDatanascimento = new JTextField();
		campoDatanascimento.setBounds(100, 106, 350, 20);
		// ---------------------------------------
		JLabel lblDatanasc = new JLabel();
		lblDatanasc.setText("Data de nasc: ");
		lblDatanasc.setBounds(10, 100, 150, 30);

		// field
		campoSexo = new JTextField();
		campoSexo.setBounds(100, 138, 350, 20);
		// ---------------------------------------
		JLabel lblSexo = new JLabel();
		lblSexo.setText("Sexo: ");
		lblSexo.setBounds(10, 130, 80, 30);

		// Adicionar elementos a janela
		janela.getContentPane().add(lblMatricula);
		janela.getContentPane().add(campoMatricula);
		// --------------------------------------
		janela.getContentPane().add(lblNome);
		janela.getContentPane().add(campoNome);
		// --------------------------------------
		janela.getContentPane().add(lblDatanasc);
		janela.getContentPane().add(campoDatanascimento);
		// --------------------------------------
		janela.getContentPane().add(lblSexo);
		janela.getContentPane().add(campoSexo);

		// Definir o componente Jbutton Cadastrar
		JButton cadastrar = new JButton();
		cadastrar.setText("Cadastrar");
		cadastrar.setBounds(100, 175, 100, 20);

		// Definir o componente Jbutton Cancelar
		JButton cancelar = new JButton();
		cancelar.setText("Cancelar");
		cancelar.setBounds(350, 175, 100, 20);

		janela.getContentPane().add(cadastrar);
		janela.getContentPane().add(cancelar);
		cancelar.addActionListener(new CancelarListener());
		cadastrar.addActionListener(new CadastrarListener());

	}

	public class CancelarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JOptionPane.showMessageDialog(null, "Cadastramento cancelado!");
			System.exit(0);

		}

	}

	public class CadastrarListener implements ActionListener {

		Aluno a1 = new Aluno();
		AlunoController alc = new AlunoController();
		boolean erro = false;

		public void actionPerformed(ActionEvent e) {
			try {

				// getters
				a1.setMatricula(campoMatricula.getText());
				a1.setNome(campoNome.getText());
				String data = (campoDatanascimento.getText());
				String sexo = (campoSexo.getText().toUpperCase());
				char auxsexo = sexo.charAt(0);
				a1.setSexo(auxsexo);
				String auxnome = a1.getNome().trim();
				String auxmatricula = a1.getMatricula().trim();

				// tratamento do campo sexo
				int contsexo = sexo.length();
				if (auxsexo != 'm' || auxsexo != 'f') {
					erro = true;	
				}
				

				// tratamento dos campos matricula e nome
				if (campoMatricula == null || campoNome == null || campoDatanascimento == null || campoSexo == null) {
					erro = true;
				}
				
				
				int contnome = auxnome.length();
				int contmatricula = auxmatricula.length();
				if ((contnome <= 0) || (contmatricula <= 0) || (contsexo != 1)) {
					erro = true;
				}

				// tratamento da data
				String data1[] = data.split("/");

				if (data1.length != 3) {
					erro = true;
				}
				int dia = (Integer.parseInt(data1[0]));
				int mes = (Integer.parseInt(data1[1]));
				int ano = (Integer.parseInt(data1[2]));

				if ((mes == 2) && (dia >= 29)) {
					erro=true;
					
				} 
				if ((dia > 31) || (dia < 0) || (mes <1) || (mes > 12) || (ano > 2020) || (ano < 1800)) {
					erro = true;
				}

				Data data2 = new Data(dia, mes, ano);

				

				if (erro = true) {
					alc.inserirAluno(a1.getMatricula(), a1.getNome(), data2, auxsexo);

					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");

					campoMatricula.setText("");
					campoNome.setText("");
					campoDatanascimento.setText("");
					campoSexo.setText("");

				}  else {
					JOptionPane.showMessageDialog(null, "Verifique se os campos estão todos preenchidos corretamente\n");
				}

			} catch (NumberFormatException N) {
				JOptionPane.showMessageDialog(null, "Verifique se os campos estão todos preenchidos corretamente");
			} catch (java.lang.ArrayIndexOutOfBoundsException A) {
				JOptionPane.showMessageDialog(null, "Verifique se os campos estão todos preenchidos corretamente");
			} catch (java.lang.StringIndexOutOfBoundsException a) {
				JOptionPane.showMessageDialog(null, "Verifique se os campos estão todos preenchidos corretamente");
			}

		}

	}
}
