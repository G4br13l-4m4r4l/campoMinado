package g4br13l.cm.visao;

import g4br13l.cm.excecao.ExplosaoException;
import g4br13l.cm.excecao.SairException;
import g4br13l.cm.modelo.Tabuleiro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class TabuleiroConsole {
	private Tabuleiro tabuleiro;
	private Scanner input = new Scanner(System.in);
	
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			while(continuar) {
				cicloDoJogo();
				
				System.out.println("Continue? (S/n)");
				String respostaContinuar = input.nextLine();
				if("n".equalsIgnoreCase(respostaContinuar)) {
					continuar = false;
				}else {
					tabuleiro.reiniciar();
				}
			}
		}catch(SairException e) {
			System.out.println("Exiting!!");
		}finally {
			input.close();
		}
	}

	private void cicloDoJogo() {
		try {
			while(tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				String digitado = CapturarValorDigitado("Digite x e y: ");
				
				Iterator<Integer> xy = Arrays.stream(digitado.split(",")).map(e->Integer.parseInt(e.trim())).iterator();
				
				digitado = CapturarValorDigitado("1- abrir ou 2- (des)marcar");
				
				if("1".equalsIgnoreCase(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				}else if("2".equals(digitado)) {
					tabuleiro.marcar(xy.next(), xy.next());
				}
			}
			
			System.out.println("You win!!");
		}catch(ExplosaoException e) {
			System.out.println("Game Over!!");
		}
		
	}
	private String CapturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = input.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		return digitado;
	}
}
