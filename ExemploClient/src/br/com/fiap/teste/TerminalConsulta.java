package br.com.fiap.teste;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.log4j.Logger;

import br.com.fiap.EstoqueBOStub;
import br.com.fiap.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.EstoqueBOStub.ProdutoTO;

public class TerminalConsulta {
	private static Logger log = Logger.getLogger(TerminalConsulta.class);
	
	public static void main(String[] args) throws RemoteException {
		log.warn("In�cio da Aplica��o");
		String nome = "Loja FIAP Run";
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = 
				DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(nome + " " + hoje.format(formatador));
		System.out.println("Digite o c�digo do produto desejado: ");
		Scanner scanner = new Scanner(System.in);
		int codigo = scanner.nextInt();
		scanner.close();
		EstoqueBOStub stub = new EstoqueBOStub();
		ConsultarProduto consulta = new ConsultarProduto();
		consulta.setCodigo(codigo);
		ConsultarProdutoResponse response = 
				stub.consultarProduto(consulta);
		ProdutoTO produto = response.get_return();
		System.out.println(produto.getDescricao());
		log.warn("Final da Aplica��o");
	}
}