package controller;

import model.Professor;

public class ProfessorController {

	public void testaProfessor() {
	
		Professor p1 = new Professor();
		
		p1.setNome("Guilherme");
		p1.setCpf("123.456.789.10");
		p1.setSalario(2500);
		p1.setMateria("Geografia");
		p1.exibe();
	
	
	}
	

	
	
	
	
	
	
}
