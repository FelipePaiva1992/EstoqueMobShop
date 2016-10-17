package br.com.mobshop.aplicacao.bo;

import java.io.Serializable;

import br.com.mobshop.ws.dao.AcessoSistemaDao;
import br.com.mobshop.ws.model.AcessoSistema;

public class LoginSistemaBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AcessoSistemaDao acessoSistemaDao;
	
	public AcessoSistema logarUsuario(String usUsuario,String vlSenha){
		acessoSistemaDao = new AcessoSistemaDao();
		return acessoSistemaDao.logarUsuarioSenha(usUsuario, vlSenha);
	}
}
