package br.com.senai.loja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.ProgramaPrincipal;
import br.com.senai.pessoa.Pessoa;
import br.com.senai.pessoa.PessoaController;
import br.com.senai.produto.Produto;
import br.com.senai.produto.ProdutoController;

public class VendaController {

	private Scanner tec;
	private ProdutoController produtoController;
	private PessoaController pessoaController;
	
	ProgramaPrincipal programaPrincipal = new ProgramaPrincipal();
	
	List<Venda> vendas = new ArrayList<>();

	public VendaController() {
		tec = new Scanner(System.in);
		produtoController = new ProdutoController();
		pessoaController = new PessoaController();
	}

	public int leOpcao() {
		System.out.print("Informe a opção desejada -> ");
		return tec.nextInt();
	}
	
	public void menuVenda(List<Pessoa> pessoas, List<Produto> produtos) {
		System.out.println("|---------- MENU DE VENDAS ----------|");
		System.out.println("|1 -> Cadastrar Vendas               |");
		System.out.println("|2 -> Listar Vendas                  |");
		System.out.println("|3 -> Voltar para o menu principal   |");
		System.out.println("|------------------------------------|");
		System.out.println("\n");
	
	boolean sair = false;
		
		do {

			int opcao = leOpcao();

			switch (opcao) {
				case 1:
					vendas.add(cadastrarVenda(produtos, pessoas));
					break;
		
				case 2:
					listarVenda(vendas);
					break;
					
				case 3:
					if(sair = true) {
						ProgramaPrincipal.menuPrincipal();
					}
					break;
					
				default:
					System.out.println("Opção Inválida!!!");
					break;
			}
	}while(!sair);
}
	public List<Venda> listarVenda(List<Venda> vendas) {
		
		System.out.println("\n");
		System.out.println("----------------- VENDAS REALIZADAS ---------------");
		System.out.println("\n");
		
		System.out.printf("| %10s | %10s | %4s | %6s | \n",
				"Cliente" , "Produto" , "Qtd" , "Valor"
		);
		
		for(int i = 0; i < vendas.size(); i++) {
			System.out.printf("| %10s | %10s | %4d | %6.2f | \n",
					vendas.get(i).getPessoa().getNome(),
					vendas.get(i).getProduto().getNomeDoProduto(),
					vendas.get(i).getQuantidade(),
					vendas.get(i).getValor()
			);
		}
		
		System.out.println("\n");
		
		return vendas;
	}
	
	public Venda cadastrarVenda(List<Produto> produtos, List<Pessoa> pessoas) {
		
		if(produtos.isEmpty() || pessoas.isEmpty()) {
			System.out.println("\n");
			System.out.println("Impossível realizar vendas sem PRODUTOS ou PESSOAS cadastradas!!");
			System.out.println("\n");
			return null;
		}
	
		produtoController.listarProdutos(produtos);
		pessoaController.listarPessoas(pessoas);
		
		Venda venda = new Venda();
		Produto produto = new Produto();
		Pessoa pessoa = new Pessoa();
		
		System.out.print("Informe o ID da pessoa -> ");
		int idPessoa = tec.nextInt() - 1;
		System.out.println("\n");
		
		pessoa.setNome(pessoas.get(idPessoa).getNome());
		pessoa.setAnoDeNascimento(pessoas.get(idPessoa).getAnoDeNascimento());
		pessoa.setAltura(pessoas.get(idPessoa).getAltura());
		
		venda.setPessoa(pessoa);
		
		System.out.print("Informe o ID do produto -> ");
		int idProduto = tec.nextInt() - 1;
		System.out.println("\n");
		
		produto.setNomeDoProduto(produtos.get(idProduto).getNomeDoProduto());
		produto.setQuantidadeDoProduto(produtos.get(idProduto).getQuantidadeDoProduto());
		produto.setValorUnitarioDoProduto(produtos.get(idProduto).getValorUnitarioDoProduto());
		produto.setValorTotalDoProduto(produtos.get(idProduto).getValorTotalDoProduto());
		
		venda.setProduto(produto);
		
		System.out.print("Informe a quantidade desejada -> ");
		venda.setQuantidade(tec.nextInt());
		System.out.println("\n");
		
		venda.setValor(produto.getValorUnitarioDoProduto() * venda.getQuantidade());
	
		return venda;

	}
}