package g4br13l.cm;

import g4br13l.cm.modelo.Tabuleiro;
import g4br13l.cm.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {

		Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
		
		new TabuleiroConsole(tabuleiro);
	}
}
