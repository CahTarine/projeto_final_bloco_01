package boate.controller;

import java.util.ArrayList;
import java.util.Optional;

import boate.model.Cadastro;
import boate.model.MaiorIdade;
import boate.repository.BoateRepository;
import conta.model.Conta;

public class BoateController implements BoateRepository{
	
	private ArrayList<Cadastro> listaCadastros = new ArrayList<>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var cadastros = buscarNaCollection(numero);
		
		if (cadastros != null) {
			cadastros.visualizar();
		} else {
			System.out.println("O cadastro número " + numero + " nao foi encontrado!");
		}
	}

	@Override
	public void listarTodas() {
		for (var cadastro : listaCadastros) {
			cadastro.visualizar();
		}
	}
	

	@Override
	public void cadastrar(Cadastro cadastro) {
		listaCadastros.add(cadastro);
		System.out.println("O cadastro número " + cadastro.getNumero() + " foi realizado com sucesso!");
	}

	@Override
	public void atualizar(Cadastro cadastro) {
		var buscaCadastro = buscarNaCollection(cadastro.getNumero());
		
		if (buscaCadastro != null) {
			listaCadastros.set(listaCadastros.indexOf(buscaCadastro), cadastro);
			System.out.println("O cadastro numero " + cadastro.getNumero() + " foi atualizado com sucesso!");
		} else {
			System.out.println("O cadastro número " + cadastro.getNumero() + " nao foi encontrado!");
		}
	}

	@Override
	public void deletar(int numero) {
		var buscaCadastro = buscarNaCollection(numero);
		
		if (buscaCadastro != null) {
			if (listaCadastros.remove(buscaCadastro) == true) {
				System.out.println("O cadastro número " + numero + " foi deletado!");
			}
		} else {
			System.out.println("O cadastro número " + numero + " nao foi encontrado!");
		}
		
	}

	@Override
	public void depositar(int numero, float valor) {
		var cadastro = buscarNaCollection(numero);
		
		if (cadastro != null) {
			cadastro.depositar(valor);
			System.out.println("O valor foi depositado!");
		} else {
			System.out.println("O cadastro número " + numero + " nao foi encontrado!");
		}
	}

	@Override
	public void comprar(int numero, float valor) {
		var cadastro = buscarNaCollection(numero);
		
		if (cadastro != null) {
			if (cadastro.comprar(valor) == true) {
				System.out.println("\nDivirta-se!");
			} 
		} else {
			System.out.println("\nO cadastro número: " + numero + " nao foi encontrado!");
		}	
		
	}
		

	
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Cadastro buscarNaCollection (int numero) {
		for (var cadastros : listaCadastros) {
			if (cadastros.getNumero() == numero) {
				return cadastros;
			}
		} 
		return null;
	}
}
