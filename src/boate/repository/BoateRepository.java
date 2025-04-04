package boate.repository;

import boate.model.Cadastro;

public interface BoateRepository {
	// CRUD
	public void procurarPorNumero (int numero);
	public void listarTodas ();
	public void cadastrar (Cadastro cadastro);
	public void atualizar (Cadastro cadastro);
	public void deletar (int numero);
	
	// Especificos
	public void depositar(int numero, float valor);
	public void comprar (int numero, float valor);
}
