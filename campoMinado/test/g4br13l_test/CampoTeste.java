package g4br13l_test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import g4br13l.cm.modelo.Campo;

public class CampoTeste {
	
	private Campo campo = new Campo(3,3);
	
		
	@Test
	void testeVizinhoReal() {
		Campo vizinho = new Campo(3,2);
		
		boolean reasultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(reasultado);
	}
	
	@Test
	void testeVizinhoReal2() {
		Campo vizinho = new Campo(2,2);
		
		boolean reasultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(reasultado);
	}
}
