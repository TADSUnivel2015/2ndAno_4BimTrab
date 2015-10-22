package br.univel.cadastro.telalogin;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaCadastroCliente extends MolduraAbstrata {

	/**
	 * Create the panel.
	 */
	public TelaCadastroCliente() {
		
		super();

	}

	// Este m�todo s� � abstrato na moldura, aqui ele deve ser concreto!
	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroCliente(), BorderLayout.CENTER);
		
	}

}
