package br.com.senai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.loja.Venda;
import br.com.senai.loja.VendaController;
import br.com.senai.pessoa.Pessoa;
import br.com.senai.pessoa.PessoaController;
import br.com.senai.produto.Produto;
import br.com.senai.produto.ProdutoController;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		Scanner tec;
		tec = new Scanner(System.in);
		
		List<Pessoa> pessoas = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		List<Venda> vendas = new ArrayList<>();
		
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

			int opcao = tec.nextInt();

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
				System.out.println("Op��o Inv�lida!!");
				
				break;

			}
			
		} while (!sair);

		System.out.println("\n");
		System.out.println("Sistema Finalizado!!!");
	}
	public void menuPrincipal() {
		System.out.println("|---------- MENU PRINCIPAL ----------|");
		System.out.println("|1 -> Pessoas                        |");
		System.out.println("|2 -> Produtos                       |");
		System.out.println("|3 -> Vendas                         |");
		System.out.println("|4 -> Finalizar Sistema              |");
		System.out.println("|------------------------------------|");
	}
}