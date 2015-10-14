package br.univel.cadastro;

public enum Uf {
	PR("Paraná"), //
	SP("São Paulo"), //
	SC("Santa Catarina"); //

	private String nome;

	public String getNome() {
		return nome;
	}

	private Uf(String nome) {
		this.nome = nome;
	}
	
}
