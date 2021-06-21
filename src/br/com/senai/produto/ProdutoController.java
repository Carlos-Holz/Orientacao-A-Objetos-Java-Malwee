package br.com.senai.produto;

import java.util.List;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class ProdutoController {

	private Scanner tec;

	public ProdutoController() {
		tec = new Scanner(System.in);
	}

	public int leOpcao() {
		System.out.print("Informe a opção desejada -> ");
		return tec.nextInt();
	}

	public void menu() {
		System.out.println("|5 -> Cadastrar Produtos            |");
		System.out.println("|6 -> Lista de Produtos Cadastrados |");
		System.out.println("|7 -> Editar produto                |");
		System.out.println("|8 -> Excluir produto               |");
		System.out.println("|9 -> Sair do Sistema               |");
		System.out.println("|-----------------------------------|");
		System.out.println("\n");
	}

	public Produto cadastrarProduto() {
		Produto produto = new Produto();

		System.out.println("---- Cadastrar Produtos ----");
		System.out.println("\n");

		System.out.print("Informe o nome do produto: ");
		produto.setNomeDoProduto(tec.next());

		System.out.print("Informe o valor unitário do produto: R$ ");
		produto.setValorUnitarioDoProduto(tec.nextDouble());

		System.out.print("Informe a quantidade do produto: ");
		produto.setQuantidadeDoProduto(tec.nextInt());
		
		produto.setValorTotalDoProduto(produto.getValorUnitarioDoProduto()*produto.getQuantidadeDoProduto());
		
		System.out.println("\n");

		return produto;
	}

	public List<Produto> listarProdutos(List<Produto> produtos){
		
		if(produtos.isEmpty()) {
			System.out.println("\n");
			System.out.println("A lista está vazia, cadastre algum produto!");
			System.out.println("\n");
			return null;
		}
		
		System.out.println("\n");
		System.out.println("----------------- PRODUTOS CADASTRADOS ---------------");
		System.out.println("\n");
		
		System.out.printf("| %2s | %10s | %10s | %13s | %9s | \n" ,
				"ID" , "Produto" , "Valor Uni." , "Quantidade" , "Total");
		
		for(int i = 0; i < produtos.size(); i++) {
			System.out.printf("| %2d | %10s | R$ %7.2f | %13d | R$ %6.2f | \n" , 
					i + 1,
					produtos.get(i).getNomeDoProduto(),
					produtos.get(i).getValorUnitarioDoProduto(),
					produtos.get(i).getQuantidadeDoProduto(),
					produtos.get(i).getValorTotalDoProduto());
		}
		System.out.println("\n");
		
		return produtos;
	}
	
	public List<Produto> editarProduto(List<Produto> produtos) {
		
		Produto produto = new Produto();
		
		listarProdutos(produtos);
		
		if(produtos.isEmpty()) {
			return null;
		}
		
		System.out.print("Informe o ID do produto para editar -> ");
		int idProduto = tec.nextInt() - 1;
		System.out.println("\n");
		
		System.out.println("|--- Campos a serem editados ---|");
		System.out.println("|1 -> Nome do produto           |");
		System.out.println("|2 -> Valor unitário do produto |");
		System.out.println("|3 -> Quantidade de produtos    |");
		System.out.println("|-------------------------------|");
		System.out.println("\n");
		System.out.print("Informe o campo que deseja editar -> ");
		int opcao = tec.nextInt();
		System.out.println("\n");
		
		switch (opcao) {
		
		case 1:
			System.out.println("---- Editar o nome do produto cadastrado ----");
			System.out.println("\n");
			System.out.print("Informe novamente  o novo do produto -> ");
			produto.setNomeDoProduto(tec.next());
			
			produto.setValorUnitarioDoProduto(produtos.get(idProduto).getValorUnitarioDoProduto());
			produto.setQuantidadeDoProduto(produtos.get(idProduto).getQuantidadeDoProduto());
			produto.setValorTotalDoProduto(produtos.get(idProduto).getValorTotalDoProduto());
			
			produtos.set(idProduto, produto);
			
			System.out.println("\n");
			break;
			
		case 2:
			System.out.println("---- Editar o valor unitário do produto cadastrado ----");
			System.out.println("\n");
			System.out.print("Informe novamente o valor unitário do produto -> R$ ");
			produto.setValorUnitarioDoProduto(tec.nextDouble());
			
			produto.setNomeDoProduto(produtos.get(idProduto).getNomeDoProduto());
			produto.setQuantidadeDoProduto(produtos.get(idProduto).getQuantidadeDoProduto());
			produto.setValorTotalDoProduto(produto.getValorUnitarioDoProduto()*produto.getQuantidadeDoProduto());

			produtos.set(idProduto, produto);
			
			System.out.println("\n");
			break;
			
		case 3:
			System.out.println("---- Editar a quantidade de produtos cadastrados ----");
			System.out.println("\n");
			System.out.print("Informe novamente a quantidade do produto -> ");
			produto.setQuantidadeDoProduto(tec.nextInt());
			
			produto.setNomeDoProduto(produtos.get(idProduto).getNomeDoProduto());
			produto.setValorUnitarioDoProduto(produtos.get(idProduto).getValorUnitarioDoProduto());
			produto.setValorTotalDoProduto(produto.getValorUnitarioDoProduto()*produto.getQuantidadeDoProduto());
			
			produtos.set(idProduto, produto);
			
			System.out.println("\n");
			break;

		default:
			System.out.println("Opção Inválida!!!!");
			break;
		}
		
		return produtos;
	}
	
	public void excluirProduto(List<Produto> produtos) {
		
		listarProdutos(produtos);
		
		if(produtos.isEmpty()) {
			return;
		}
		
		System.out.println("----------------- EXCLUIR PRODUTO ---------------");
		System.out.println("\n");
		
		System.out.print("Informe o ID do produto que deseja excluir -> ");
		int idProduto = tec.nextInt() - 1;
		System.out.println("\n");
		
		if(produtos.size() <= idProduto) {
			System.out.println("\n");
			System.out.println("Produto não cadastrado!!");
			System.out.println("\n");
			return;
		}
		
		produtos.remove(idProduto);
	}
}