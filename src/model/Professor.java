package model;

/**
 * Esta classe é responsável pelas informações de Professora
 * 
 * @author gtbrito
 * @since 17/02/2020
 * @version 0.1
 */

public class Professor extends Funcionario {

	
	private String materia;

	public Professor() {
	
	System.out.println("Professor Criado!");
	}

	public Professor(String materia) {
		this.materia = materia;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

public void exibe() {
	super.exibe();
	System.out.println("A matéria do professor é: "+materia);
}
	
	
	


}
