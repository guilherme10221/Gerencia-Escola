package model;

/**
 * Esta classe � respons�vel pelas informa��es de Professora
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
	System.out.println("A mat�ria do professor �: "+materia);
}
	
	
	


}
