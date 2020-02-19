package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import model.Aluno;
import model.Data;

public class AlunoController {

	public void inserirAluno(String matricula, String nome, Data data, char sexo) {
		Aluno a1 = new Aluno();
		a1.setMatricula(matricula);
		a1.setNome(nome);
		a1.setDataNascimento(data);
		a1.setSexo(sexo);

		
		try {
			
			File arquivo = new File("aluno.txt");
			FileOutputStream arquivoOutput;

			arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);

//			Gravação Aluno 1 

			gravador.print(a1.getMatricula());
			gravador.print(";");
			gravador.print(a1.getNome());
			gravador.print(";");
			gravador.print(a1.getDataNascimento().toString());
			gravador.print(";");
			gravador.println(a1.getSexo());
			
			gravador.close();
			arquivoOutput.close();



			System.out.println("Os alunos foram registrados com sucesso!");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void listarTodos() {

		try {
			InputStream is;
			is = new FileInputStream("aluno.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			
			String texto = leitor.readLine();

			while (texto != null) {
				String dados[] = texto.split(";");
				
				System.out.println("Matrícula: " + dados[0]);
				System.out.println("Nome do aluno: " + dados[1]);
				System.out.println("Data de nascimento: " + dados[2]);
				System.out.println("Sexo (F=Feminino e M=Masculino): " + dados[3]);
				texto = leitor.readLine();

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.out.println("Arquivo de entrada não encontrado");
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("Arquivo de entrada não encontrado");
		}

	}

	public void listarAniversariantes(int mes) {

		try {
			InputStream is;
			is = new FileInputStream("aluno.txt");

			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();

			while (texto != null) {
				String dados[] = texto.split(";");
				String data[] = dados[2].split("/");
				
				int aniversariantemes = Integer.parseInt(data[1]);
				
				if (aniversariantemes == mes) {
					System.out.println("Nº de matricula: " + dados[0]);
					System.out.println("Nome do aluno: " + dados[1]);
					System.out.println("Data de nascimento: " + dados[2]);
					System.out.println("Sexo (F=Feminino e M=Masculino): " + dados[3]);
					texto = leitor.readLine();
				}
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.out.println("Arquivo de entrada não encontrado");
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("Arquivo de entrada não encontrado");
		}

	}

}
