package br.com.senai.pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PessoaController {

	private Scanner tec;
	
	List<Pessoa> pessoas = new ArrayList<>();
	
	public PessoaController(){
		tec = new Scanner(System.in);
	}
	
	public int leOpcao(){
		System.out.println("\n");
		System.out.print("Informe a opção desejada -> ");
		return tec.nextInt();
	} 
	
	public void menuPessoa(List<Pessoa> pessoas) {
		
		boolean sair = false;
		
		do {
			System.out.println("|---------- MENU PESSOAS -----------|");
			System.out.println("|1 -> Cadastrar Pessoas             |");
			System.out.println("|2 -> Lista de Pessoas Cadastradas  |");
			System.out.println("|3 -> Editar Pessoas Cadastradas    |");
			System.out.println("|4 -> Excluir Pessoas Cadastradas   |");
			System.out.println("|-----------------------------------|");


			int opcao = leOpcao();

			switch (opcao) {
			
			case 1:
				System.out.println("\n");
				pessoas.add(cadastrarPessoa());
				break;

			case 2:
				listarPessoas(pessoas);
				break;
				
			case 3:
				editarPessoa(pessoas);
				break;
				
			case 4:
				excluirPessoa(pessoas);
				break;
				
			default:
				System.out.println("Opção Inválida!!!");
				break;
			}
			System.out.print("Deseja retornar ao MENU PRINCIPAL? [S/N] -> ");
			String resposta = tec.next();
			sair = resposta.equalsIgnoreCase("s") ? true : false;
			System.out.println("\n");
			
	} while(sair);
}
	public Pessoa cadastrarPessoa() {
		Pessoa pessoa = new Pessoa();
		
		System.out.println("---- Cadastrar Pessoas ----");
		System.out.println("\n");
		
		System.out.print("Informe o seu nome: ");
		tec.nextLine();
		pessoa.setNome(tec.nextLine());
		
		System.out.print("Informe o seu Ano de Nascimento: ");
		pessoa.setAnoDeNascimento(tec.nextInt());
		
		System.out.print("Informe a sua altura: ");
		pessoa.setAltura(tec.nextDouble());
		
		System.out.print("Informe o País que você mora: ");
		tec.nextLine();
		pessoa.setNomeDoPais(tec.nextLine());
		
		System.out.print("Informe a Sigla do País que você vive: ");
		pessoa.setSiglaDoPais(tec.nextLine());
		
		System.out.print("Informe o Estado em que você reside: ");
		pessoa.setNomeDoEstado(tec.nextLine());
		
		System.out.print("Informe o UF: ");
		pessoa.setUf(tec.nextLine());
		
		System.out.print("Informe a Cidade que você reside: ");
		pessoa.setNomeDaCidade(tec.nextLine());
		
		System.out.print("Informe o nome da Rua que você mora: ");
		pessoa.setNomeDaRua(tec.nextLine());
		
		System.out.print("Informe o Bairro: ");
		pessoa.setBairro(tec.nextLine());
		
		System.out.print("Complemento: ");
		pessoa.setComplemento(tec.nextLine());
		
		System.out.print("Número: ");
		pessoa.setNumero(tec.nextLine());
		System.out.println("\n");
		
		return pessoa;
	}
	
	public List<Pessoa> listarPessoas(List<Pessoa> pessoas){
		
		if(pessoas.isEmpty()) {
			System.out.println("\n");
			System.out.println("A lista está vazia, cadastre alguma pessoa!");
			System.out.println("\n");
			return null;
		}
		
		System.out.println("\n");
		System.out.println("--------------------------------------------------------------------------------------------------------------------- PESSOAS CADASTRADADS -------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n");
		
		System.out.printf("| %2s | %15s | %20s | %20s | %20s | %20s| %21s | %23s | %20s | %30s | %30s | %30s | %21s | %30s | \n" ,
				 "ID" , "Nome" , "Ano" , "Idade" , "Altura", "País" , "Sigla Páis", "Estado" , "UF" , "Cidade" , "Rua" , "Bairro" , "Complemento" , "Número");
		
		for(int i = 0; i < pessoas.size(); i++) {
			System.out.printf("| %2d | %15s | %20d | %20d | %20s | %19s | %21s | %23s | %20s | %30s | %30s | %30s | %21s | %30s | \n" ,
					i + 1,
					pessoas.get(i).getNome(),
					pessoas.get(i).getAnoDeNascimento(),
					pessoas.get(i).getIdade(),
					pessoas.get(i).getAltura(),
					pessoas.get(i).getNomeDoPais(),
					pessoas.get(i).getSiglaDoPais(),
					pessoas.get(i).getNomeDoEstado(),
					pessoas.get(i).getUf(),
					pessoas.get(i).getNomeDaCidade(),
					pessoas.get(i).getNomeDaRua(),
					pessoas.get(i).getBairro(),
					pessoas.get(i).getComplemento(),
					pessoas.get(i).getNumero());
		}
		System.out.println("\n");

		return pessoas;
	}
	
	public List<Pessoa> editarPessoa(List<Pessoa> pessoas) {
		
		Pessoa pessoa = new Pessoa();
		
		listarPessoas(pessoas);
		
		if(pessoas.isEmpty()) {
			return null;
		}
		
		System.out.print("Informe o ID da pessoa para editar -> ");
		int idPessoa = tec.nextInt() - 1;
		System.out.println("\n");
		
		System.out.println("|--- Campos a serem editados ---|");
		System.out.println("|1 -> Nome da pessoa            |");
		System.out.println("|2 -> Ano de nascimento         |");
		System.out.println("|3 -> Altura                    |");
		System.out.println("|4 -> País                      |");
		System.out.println("|5 -> Sigla do País             |");
		System.out.println("|6 -> Estado                    |");
		System.out.println("|7 -> UF                        |");
		System.out.println("|8 -> Cidade                    |");
		System.out.println("|9 -> Rua                       |");
		System.out.println("|10 -> Bairro                   |");
		System.out.println("|11 -> Complemento              |");
		System.out.println("|12 -> Número                   |");
		System.out.println("|-------------------------------|");
		System.out.println("\n");
		System.out.print("Informe o campo que deseja editar -> ");
		int opcao = tec.nextInt();
		System.out.println("\n");
		
		switch (opcao) {
		
		case 1:
			System.out.println("---- Editar o nome da pessoa cadastrada ----");
			System.out.println("\n");
			System.out.print("Informe o novo nome da pessoa -> ");
			pessoa.setNome(tec.next());
			
			pessoa.setAnoDeNascimento(pessoas.get(idPessoa).getAnoDeNascimento());
			pessoa.setAltura(pessoas.get(idPessoa).getAltura());
			pessoa.setNomeDoPais(pessoas.get(idPessoa).getNomeDoPais());
			pessoa.setSiglaDoPais(pessoas.get(idPessoa).getSiglaDoPais());
			pessoa.setNomeDoEstado(pessoas.get(idPessoa).getNomeDoEstado());
			pessoa.setUf(pessoas.get(idPessoa).getUf());
			pessoa.setNomeDaCidade(pessoas.get(idPessoa).getNomeDaCidade());
			pessoa.setNomeDaRua(pessoas.get(idPessoa).getNomeDaRua());
			pessoa.setBairro(pessoas.get(idPessoa).getBairro());
			pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());
			pessoa.setNumero(pessoas.get(idPessoa).getNumero());
			
			pessoas.set(idPessoa, pessoa);
			
			System.out.println("\n");
			break;
			
		case 2:
			System.out.println("---- Editar o ano de nascimento da pessoa cadastrada ----");
			System.out.println("\n");
			System.out.print("Informe o novo ano de nascimento -> ");
			pessoa.setAnoDeNascimento(tec.nextInt());
			
			pessoa.setNome(pessoas.get(idPessoa).getNome());
			pessoa.setAltura(pessoas.get(idPessoa).getAltura());
			pessoa.setNomeDoPais(pessoas.get(idPessoa).getNomeDoPais());
			pessoa.setSiglaDoPais(pessoas.get(idPessoa).getSiglaDoPais());
			pessoa.setNomeDoEstado(pessoas.get(idPessoa).getNomeDoEstado());
			pessoa.setUf(pessoas.get(idPessoa).getUf());
			pessoa.setNomeDaCidade(pessoas.get(idPessoa).getNomeDaCidade());
			pessoa.setNomeDaRua(pessoas.get(idPessoa).getNomeDaRua());
			pessoa.setBairro(pessoas.get(idPessoa).getBairro());
			pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());
			pessoa.setNumero(pessoas.get(idPessoa).getNumero());
			
			pessoas.set(idPessoa, pessoa);
			
			System.out.println("\n");
			break;
			
		case 3:
			System.out.println("---- Editar a altura da pessoa cadastrada ----");
			System.out.println("\n");
			System.out.print("Informe a nova altura da pessoa -> ");
			pessoa.setAltura(tec.nextDouble());
			
			pessoa.setNome(pessoas.get(idPessoa).getNome());
			pessoa.setAnoDeNascimento(pessoas.get(idPessoa).getAnoDeNascimento());
			pessoa.setNomeDoPais(pessoas.get(idPessoa).getNomeDoPais());
			pessoa.setSiglaDoPais(pessoas.get(idPessoa).getSiglaDoPais());
			pessoa.setNomeDoEstado(pessoas.get(idPessoa).getNomeDoEstado());
			pessoa.setUf(pessoas.get(idPessoa).getUf());
			pessoa.setNomeDaCidade(pessoas.get(idPessoa).getNomeDaCidade());
			pessoa.setNomeDaRua(pessoas.get(idPessoa).getNomeDaRua());
			pessoa.setBairro(pessoas.get(idPessoa).getBairro());
			pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());
			pessoa.setNumero(pessoas.get(idPessoa).getNumero());
			
			pessoas.set(idPessoa, pessoa);
			
			System.out.println("\n");
			break;
		
		case 4:
			System.out.println("---- Editar o país em que vive a pessoa cadastrada ----");
			System.out.println("\n");
			System.out.print("Informe o novo país da pessoa -> ");
			pessoa.setNomeDoPais(tec.next());
			
			pessoa.setNome(pessoas.get(idPessoa).getNome());
			pessoa.setAnoDeNascimento(pessoas.get(idPessoa).getAnoDeNascimento());
			pessoa.setAltura(pessoas.get(idPessoa).getAltura());
			pessoa.setSiglaDoPais(pessoas.get(idPessoa).getSiglaDoPais());
			pessoa.setNomeDoEstado(pessoas.get(idPessoa).getNomeDoEstado());
			pessoa.setUf(pessoas.get(idPessoa).getUf());
			pessoa.setNomeDaCidade(pessoas.get(idPessoa).getNomeDaCidade());
			pessoa.setNomeDaRua(pessoas.get(idPessoa).getNomeDaRua());
			pessoa.setBairro(pessoas.get(idPessoa).getBairro());
			pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());
			pessoa.setNumero(pessoas.get(idPessoa).getNumero());
			
			pessoas.set(idPessoa, pessoa);
			
			System.out.println("\n");
			break;
			
		case 5:
			System.out.println("---- Editar a sigla do país cadastrado ----");
			System.out.println("\n");
			System.out.print("Informe a nova sigla -> ");
			pessoa.setSiglaDoPais(tec.next());
			
			pessoa.setNome(pessoas.get(idPessoa).getNome());
			pessoa.setAnoDeNascimento(pessoas.get(idPessoa).getAnoDeNascimento());
			pessoa.setAltura(pessoas.get(idPessoa).getAltura());
			pessoa.setNomeDoPais(pessoas.get(idPessoa).getNomeDoPais());
			pessoa.setNomeDoEstado(pessoas.get(idPessoa).getNomeDoEstado());
			pessoa.setUf(pessoas.get(idPessoa).getUf());
			pessoa.setNomeDaCidade(pessoas.get(idPessoa).getNomeDaCidade());
			pessoa.setNomeDaRua(pessoas.get(idPessoa).getNomeDaRua());
			pessoa.setBairro(pessoas.get(idPessoa).getBairro());
			pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());
			pessoa.setNumero(pessoas.get(idPessoa).getNumero());
			
			pessoas.set(idPessoa, pessoa);
			
			System.out.println("\n");
			break;
			
		case 6:
			System.out.println("---- Editar o estado cadastrado ----");
			System.out.println("\n");
			System.out.print("Informe o novo estado -> ");
			pessoa.setNomeDoEstado(tec.next());
			
			pessoa.setNome(pessoas.get(idPessoa).getNome());
			pessoa.setAnoDeNascimento(pessoas.get(idPessoa).getAnoDeNascimento());
			pessoa.setAltura(pessoas.get(idPessoa).getAltura());
			pessoa.setNomeDoPais(pessoas.get(idPessoa).getNomeDoPais());
			pessoa.setSiglaDoPais(pessoas.get(idPessoa).getSiglaDoPais());
			pessoa.setUf(pessoas.get(idPessoa).getUf());
			pessoa.setNomeDaCidade(pessoas.get(idPessoa).getNomeDaCidade());
			pessoa.setNomeDaRua(pessoas.get(idPessoa).getNomeDaRua());
			pessoa.setBairro(pessoas.get(idPessoa).getBairro());
			pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());
			pessoa.setNumero(pessoas.get(idPessoa).getNumero());
			
			pessoas.set(idPessoa, pessoa);
			
			System.out.println("\n");
			break;
			
		case 7:
			System.out.println("---- Editar o UF cadastrado ----");
			System.out.println("\n");
			System.out.print("Informe o novo UF -> ");
			pessoa.setUf(tec.next());
			
			pessoa.setNome(pessoas.get(idPessoa).getNome());
			pessoa.setAnoDeNascimento(pessoas.get(idPessoa).getAnoDeNascimento());
			pessoa.setAltura(pessoas.get(idPessoa).getAltura());
			pessoa.setNomeDoPais(pessoas.get(idPessoa).getNomeDoPais());
			pessoa.setSiglaDoPais(pessoas.get(idPessoa).getSiglaDoPais());
			pessoa.setNomeDoEstado(pessoas.get(idPessoa).getNomeDoEstado());
			pessoa.setNomeDaCidade(pessoas.get(idPessoa).getNomeDaCidade());
			pessoa.setNomeDaRua(pessoas.get(idPessoa).getNomeDaRua());
			pessoa.setBairro(pessoas.get(idPessoa).getBairro());
			pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());
			pessoa.setNumero(pessoas.get(idPessoa).getNumero());
			
			pessoas.set(idPessoa, pessoa);
			
			System.out.println("\n");
			break;
			
		case 8:
			System.out.println("---- Editar a cidade cadastrada ----");
			System.out.println("\n");
			System.out.print("Informe a nova cidade -> ");
			pessoa.setNomeDaCidade(tec.next());
			
			pessoa.setNome(pessoas.get(idPessoa).getNome());
			pessoa.setAnoDeNascimento(pessoas.get(idPessoa).getAnoDeNascimento());
			pessoa.setAltura(pessoas.get(idPessoa).getAltura());
			pessoa.setNomeDoPais(pessoas.get(idPessoa).getNomeDoPais());
			pessoa.setSiglaDoPais(pessoas.get(idPessoa).getSiglaDoPais());
			pessoa.setNomeDoEstado(pessoas.get(idPessoa).getNomeDoEstado());
			pessoa.setUf(pessoas.get(idPessoa).getUf());
			pessoa.setNomeDaRua(pessoas.get(idPessoa).getNomeDaRua());
			pessoa.setBairro(pessoas.get(idPessoa).getBairro());
			pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());
			pessoa.setNumero(pessoas.get(idPessoa).getNumero());
			
			pessoas.set(idPessoa, pessoa);
			
			System.out.println("\n");
			break;
			
		case 9:
			System.out.println("---- Editar a rua cadastrada ----");
			System.out.println("\n");
			System.out.print("Informe a nova rua -> ");
			tec.nextLine();
			pessoa.setNomeDaRua(tec.nextLine());
			
			pessoa.setNome(pessoas.get(idPessoa).getNome());
			pessoa.setAnoDeNascimento(pessoas.get(idPessoa).getAnoDeNascimento());
			pessoa.setAltura(pessoas.get(idPessoa).getAltura());
			pessoa.setNomeDoPais(pessoas.get(idPessoa).getNomeDoPais());
			pessoa.setSiglaDoPais(pessoas.get(idPessoa).getSiglaDoPais());
			pessoa.setNomeDoEstado(pessoas.get(idPessoa).getNomeDoEstado());
			pessoa.setUf(pessoas.get(idPessoa).getUf());
			pessoa.setNomeDaCidade(pessoas.get(idPessoa).getNomeDaCidade());
			pessoa.setBairro(pessoas.get(idPessoa).getBairro());
			pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());
			pessoa.setNumero(pessoas.get(idPessoa).getNumero());
			
			pessoas.set(idPessoa, pessoa);
			
			System.out.println("\n");
			break;
			
		case 10:
			System.out.println("---- Editar o bairro cadastrado ----");
			System.out.println("\n");
			System.out.print("Informe o novo bairro -> ");
			pessoa.setBairro(tec.next());
			
			pessoa.setNome(pessoas.get(idPessoa).getNome());
			pessoa.setAnoDeNascimento(pessoas.get(idPessoa).getAnoDeNascimento());
			pessoa.setAltura(pessoas.get(idPessoa).getAltura());
			pessoa.setNomeDoPais(pessoas.get(idPessoa).getNomeDoPais());
			pessoa.setSiglaDoPais(pessoas.get(idPessoa).getSiglaDoPais());
			pessoa.setNomeDoEstado(pessoas.get(idPessoa).getNomeDoEstado());
			pessoa.setUf(pessoas.get(idPessoa).getUf());
			pessoa.setNomeDaCidade(pessoas.get(idPessoa).getNomeDaCidade());
			pessoa.setNomeDaRua(pessoas.get(idPessoa).getNomeDaRua());
			pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());
			pessoa.setNumero(pessoas.get(idPessoa).getNumero());
			
			pessoas.set(idPessoa, pessoa);
			
			System.out.println("\n");
			break;
			
		case 11:
			System.out.println("---- Editar o complemento cadastrado ----");
			System.out.println("\n");
			System.out.print("Informe o novo complemento -> ");
			pessoa.setComplemento(tec.next());
			
			pessoa.setNome(pessoas.get(idPessoa).getNome());
			pessoa.setAnoDeNascimento(pessoas.get(idPessoa).getAnoDeNascimento());
			pessoa.setAltura(pessoas.get(idPessoa).getAltura());
			pessoa.setNomeDoPais(pessoas.get(idPessoa).getNomeDoPais());
			pessoa.setSiglaDoPais(pessoas.get(idPessoa).getSiglaDoPais());
			pessoa.setNomeDoEstado(pessoas.get(idPessoa).getNomeDoEstado());
			pessoa.setUf(pessoas.get(idPessoa).getUf());
			pessoa.setNomeDaCidade(pessoas.get(idPessoa).getNomeDaCidade());
			pessoa.setNomeDaRua(pessoas.get(idPessoa).getNomeDaRua());
			pessoa.setBairro(pessoas.get(idPessoa).getBairro());
			pessoa.setNumero(pessoas.get(idPessoa).getNumero());
			
			pessoas.set(idPessoa, pessoa);
			
			System.out.println("\n");
			break;
			
		case 12:
			System.out.println("---- Editar o número cadastrado ----");
			System.out.println("\n");
			System.out.print("Informe o novo número -> ");
			pessoa.setNumero(tec.next());
			
			pessoa.setNome(pessoas.get(idPessoa).getNome());
			pessoa.setAnoDeNascimento(pessoas.get(idPessoa).getAnoDeNascimento());
			pessoa.setAltura(pessoas.get(idPessoa).getAltura());
			pessoa.setNomeDoPais(pessoas.get(idPessoa).getNomeDoPais());
			pessoa.setSiglaDoPais(pessoas.get(idPessoa).getSiglaDoPais());
			pessoa.setNomeDoEstado(pessoas.get(idPessoa).getNomeDoEstado());
			pessoa.setUf(pessoas.get(idPessoa).getUf());
			pessoa.setNomeDaCidade(pessoas.get(idPessoa).getNomeDaCidade());
			pessoa.setNomeDaRua(pessoas.get(idPessoa).getNomeDaRua());
			pessoa.setBairro(pessoas.get(idPessoa).getBairro());
			pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());
			
			pessoas.set(idPessoa, pessoa);
			
			System.out.println("\n");
			break;
}
		return pessoas;
	}
	
	public void excluirPessoa(List<Pessoa> pessoas) {
		
		listarPessoas(pessoas);
		
		if(pessoas.isEmpty()) {
			return;
		}
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------- EXCLUIR PESSOA -------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n");
		
		System.out.print("Informe o ID da pessoa que deseja excluir -> ");
		int idPessoa = tec.nextInt() - 1;
		System.out.println("\n");
		
		if(pessoas.size() <= idPessoa) {
			System.out.println("\n");
			System.out.println("Pessoa não cadastrado!!");
			System.out.println("\n");
			return;
		}
		
		pessoas.remove(idPessoa);
	}
}	