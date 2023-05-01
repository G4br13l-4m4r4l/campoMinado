package g4br13l_test;

import static org.junit.Assert.assertFalse;
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
	
	@Test
	void testeAlternaMarcacao() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternaValorMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternamarcacaoDuasVezes() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minado();
		assertFalse(campo.abrir());
	}
//	@Test
//	void testeAbrirMinadoNaoMarcado() {
//		campo.minado();
//		
//		assertThrows(ExplosaoException.class, ()->{campo.abrir();});
//		assertFalse(campo.abrir());
//	}
	
	@Test
	void testeAbrirComVizinho() {
		Campo vizinho1 = new Campo(2,2);
		Campo vizinhoDoVizinho1 = new Campo(1,1);
		
		vizinho1.adicionarVizinho(vizinhoDoVizinho1);
		
		campo.adicionarVizinho(vizinho1);
		campo.abrir();
		
		assertTrue(campo.isAberto() && vizinho1.isAberto());
	}
}
