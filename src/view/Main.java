package view;
import controller.SemaforoCaixaEletronico;
import java.util.concurrent.Semaphore;


public class Main {
	
public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		Semaphore semaforo1 = new Semaphore(permissoes);
		
		for (int i = 0; i < 20; i++){
			int conta = (int)((Math.random() * 500) + 1);
			double saldo = ((Math.random() * 50) + 0.1);
			int valor = (int)((Math.random() * saldo) + 20);
				
			SemaforoCaixaEletronico semaforoCaixaEletronico = new SemaforoCaixaEletronico(conta, valor, saldo, semaforo, semaforo1);
			semaforoCaixaEletronico.start();
		}
	}
}
