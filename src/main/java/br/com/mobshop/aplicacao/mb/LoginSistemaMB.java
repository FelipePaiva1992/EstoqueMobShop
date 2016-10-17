package br.com.mobshop.aplicacao.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.mobshop.aplicacao.bo.LoginSistemaBO;
import br.com.mobshop.ws.model.AcessoSistema;

@ManagedBean
@SessionScoped
public class LoginSistemaMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String senha;
	private Boolean isAdm;
	private Boolean isOp;
	
	LoginSistemaBO loginSistemaBO;
	
	@PostConstruct
	private void init() {
		isAdm = false;
		isOp = false;
	}
	
	public LoginSistemaMB() {
		isAdm = false;
		isOp = false;
	}
	
	public String logarSistema(){
		loginSistemaBO = new LoginSistemaBO();
		AcessoSistema acessoSistema = loginSistemaBO.logarUsuario(usuario, senha);
		if(acessoSistema != null){
			if(acessoSistema.getPerfilAcesso().getIdPerfilAcesso() == 1){
				isAdm = true;
				isOp = true;
				return "venda.jsf?faces-redirect=true";			
			}else if(acessoSistema.getPerfilAcesso().getIdPerfilAcesso() == 2){
				isAdm = false;
				isOp = true;
				return "venda.jsf?faces-redirect=true";			
			}else{
				isAdm = false;
				isOp = false;
				return null;
			}
		}else{
			return "login.jsf?faces-redirect=true";
		}
	}
	
	public String logout(){
		isAdm = false;
		isOp = false;
		return "login.jsf?faces-redirect=true";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getIsAdm() {
		return isAdm;
	}

	public void setIsAdm(Boolean isAdm) {
		this.isAdm = isAdm;
	}

	public Boolean getIsOp() {
		return isOp;
	}

	public void setIsOp(Boolean isOp) {
		this.isOp = isOp;
	}

}
