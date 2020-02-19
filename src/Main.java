import controller.AlunoController;
import view.AlunoView;
//import controller.ProfessorController;

public class Main {


	public static void main(String[] args) {
	
//		ProfessorController pf1 = new ProfessorController();
//		pf1.testaProfessor();
		
		AlunoController exec = new AlunoController();
		
//		exec.listarTodos();
//		exec.listarAniversariantes(10);
	    new AlunoView();	
		
		
}

}
