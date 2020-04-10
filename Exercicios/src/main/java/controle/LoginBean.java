package controle;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidade.Usuario;
import util.JpaUtil;




@ManagedBean(name= "LoginBean")
@RequestScoped
public class LoginBean {	

	
	private String usuarioAdmin = "admin";
	private String senhaAdmin = "admin";
	
	private String usuarioTXT;
	private String senhaTXT;
	
	private static final String PESQUISAR = "paginas/usuario/pesquisarUsuario.xhtml"; 
	private UsuarioDAO usuarioDAO;
	private String mensagem;
	
	public LoginBean() { 
		this.usuarioDAO = new UsuarioDAOImpl(JpaUtil.getEntityManager());
	}
	
		public void entrar() throws IOException {
		if(this.usuarioTXT.equals(this.usuarioAdmin)
		  && this.senhaTXT.equals(this.senhaAdmin)) {
			FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
		}else { 
			Usuario usuarioPesquisa = this.usuarioDAO.pesquisar(this.usuarioTXT);
			if(usuarioPesquisa != null) {
				if(usuarioPesquisa.getSenha().equals(this.senhaTXT)) {
					FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
				}else {
					this.mensagem = "Senha errada";
				}
			}else {
				this.mensagem = "Nao existe";				
				
			}
			
		}
	}

	public String getUsuarioTXT() {
		return usuarioTXT;
	}

	public void setUsuarioTXT(String usuarioTXT) {
		this.usuarioTXT = usuarioTXT;
	}

	public String getSenhaTXT() {
		return senhaTXT;
	}

	public void setSenhaTXT(String senhaTXT) {
		this.senhaTXT = senhaTXT;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}


}
