package controller;
import java.util.concurrent.Semaphore;

public class SemaforoCaixaEletronico extends Thread{
	
	private int conta;
	private int valor;
	private double saldo;
	private Semaphore semaforo;
	private Semaphore semaforo1;
	
	public SemaforoCaixaEletronico(int conta, int valor, double saldo, Semaphore semaforo, Semaphore semaforo1) {
		super();
		this.conta = conta;
		this.valor = valor;
		this.saldo = saldo;
		this.semaforo = semaforo;
		this.semaforo1 = semaforo1;
	}
	@Override
	public void run() {		
			if (this.conta % 2 == 0){
				try{
					semaforo.acquire();
					sacar();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
				}
			} else {
				try{
					semaforo1.acquire();
					depositar();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo1.release();
				}
			}
			
		
		verSaldo();
	}

	private void depositar() {
		try {
			System.out.println("Realizando depósito...");
			this.saldo += this.valor;
			sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Depósito na conta " + this.conta + " realizado com sucesso!");
		
	}

	private void sacar() {
		try {
			System.out.println("Realizando saque...");
			this.saldo -= this.valor;
			sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Saque da conta " + this.conta + " realizado com sucesso!");
	}
	
	private void verSaldo() {
		System.out.println("Total Saldo: R$ " + this.saldo);
	}

}
