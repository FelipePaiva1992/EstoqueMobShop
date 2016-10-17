package br.com.mobshop.aplicacao.bo;

import java.io.Serializable;

import br.com.mobshop.ws.dao.AcessoSistemaDao;
import br.com.mobshop.ws.dao.VendedorDao;
import br.com.mobshop.ws.model.AcessoSistema;
import br.com.mobshop.ws.model.Vendedor;

public class CadastroFuncionarioBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AcessoSistemaDao acessoSistemaDao;
	
	VendedorDao vendedorDao;
	
	public Vendedor cadastrarVendedor(String nmVendedor,String vlSenha){
		vendedorDao = new VendedorDao();
		return vendedorDao.cadastrarVendedor(nmVendedor, vlSenha);
	}
	
	public AcessoSistema cadastrarFuncionario(String usUsuario,String nmUsuario,String vlSenha,String idPerfil){
		acessoSistemaDao = new AcessoSistemaDao();
		return acessoSistemaDao.criarUsuarioSistema(usUsuario, nmUsuario, vlSenha, idPerfil);
	}
}
