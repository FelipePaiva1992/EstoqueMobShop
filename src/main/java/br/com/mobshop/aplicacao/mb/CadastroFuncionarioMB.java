package br.com.mobshop.aplicacao.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.mobshop.aplicacao.bo.CadastroFuncionarioBO;
import br.com.mobshop.ws.model.AcessoSistema;
import br.com.mobshop.ws.model.Vendedor;

@ManagedBean
@SessionScoped
public class CadastroFuncionarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nmFuncionario;
	private String email;
	private String usuario;
	private String senha;
	private String confSenha;
	private List<SelectItem> perfil = new ArrayList<SelectItem>();
	private String perfilSelecionado;
	
	CadastroFuncionarioBO cadastroFuncionarioBO;
	
	@PostConstruct
	public void init() {
		perfil.add(new SelectItem("2", "Operacional"));
		perfil.add(new SelectItem("1", "Administrador"));
		perfil.add(new SelectItem("3", "Vendedor"));
	}
	
	public void limparFormulario(){
		nmFuncionario = "";
		email = "";
		usuario = "";
		senha = "";
		confSenha = "";
		perfilSelecionado = "";
	}
	
	@SuppressWarnings("unused")
	public void cadastrarFuncionario(){
		cadastroFuncionarioBO = new CadastroFuncionarioBO();
		int perf = Integer.parseInt(perfilSelecionado);
		Vendedor vendedor;
		AcessoSistema acessoSistema;
		switch (perf) {
		case 1:
			acessoSistema = cadastroFuncionarioBO.cadastrarFuncionario(usuario, nmFuncionario, senha, perfilSelecionado);
			break;
		case 2:
			acessoSistema = cadastroFuncionarioBO.cadastrarFuncionario(usuario, nmFuncionario, senha, perfilSelecionado);
			break;
		case 3:
			vendedor = cadastroFuncionarioBO.cadastrarVendedor(nmFuncionario, senha);
			this.usuario = String.valueOf(vendedor.getIdVendedor());
			break;
		}		
	}
	
	public String getNmFuncionario() {
		return nmFuncionario;
	}
	public void setNmFuncionario(String nmFuncionario) {
		this.nmFuncionario = nmFuncionario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getConfSenha() {
		return confSenha;
	}
	public void setConfSenha(String confSenha) {
		this.confSenha = confSenha;
	}
	public List<SelectItem> getPerfil() {
		return perfil;
	}
	public void setPerfil(List<SelectItem> perfil) {
		this.perfil = perfil;
	}
	public String getPerfilSelecionado() {
		return perfilSelecionado;
	}
	public void setPerfilSelecionado(String perfilSelecionado) {
		this.perfilSelecionado = perfilSelecionado;
	}
	
	

}
