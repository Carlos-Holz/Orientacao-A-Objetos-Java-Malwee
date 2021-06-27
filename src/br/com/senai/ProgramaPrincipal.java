package br.com.senai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.loja.VendaController;
import br.com.senai.pessoa.Pessoa;
import br.com.senai.pessoa.PessoaController;
import br.com.senai.produto.Produto;
import br.com.senai.produto.ProdutoController;

public class ProgramaPrincipal {
	
	private static Scanner tec;
	
	public ProgramaPrincipal() {
		tec = new Scanner(System.in);
	}
	
	public static void menuPrincipal() {
		System.out.println("\n");
		System.out.println("|---------- MENU PRINCIPAL ----------|");
		System.out.println("|1 -> Pessoas                        |");
		System.out.println("|2 -> Produtos                       |");
		System.out.println("|3 -> Vendas                         |");
		System.out.println("|4 -> Finalizar Sistema              |");
		System.out.println("|------------------------------------|");
		
	}

	public static void main(String[] args) {
		
		
		List<Pessoa> pessoas = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		
		Produto produto = new Produto(
				"Abacate", 
				2.5, 
				35, 
				2.5 * 35
				);
		
		produtos.add(produto);

		PessoaController pessoaController = new PessoaController();
		ProdutoController produtoController = new ProdutoController();
		VendaController vendaController = new VendaController();

		boolean sair = false;

		do {

			ProgramaPrincipal.menuPrincipal();
			System.out.println("\n");
			System.out.print("Informe a opção desejada -> ");
			int opcao = tec.nextInt();
			System.out.println("\n");
					
			switch (opcao) {
			
			case 1:
				pessoaController.menuPessoa(pessoas);
				break;

			case 2:
				produtoController.menuProduto(produtos);
				break;
				
			case 3:
				vendaController.menuVenda(pessoas, produtos);
				break;
				
			case 4:
				sair = true;
				
				break;

			default:
				System.out.println("\n");
				System.out.println("Opção Inválida!!");
				
				break;

			}
			
		} while (!sair);

		System.out.println("\n");
		System.out.println("Sistema Finalizado!!!");
	}
}