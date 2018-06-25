
package br.com.academicci.bean;

import java.io.Serializable;
import br.com.academicci.entity.LoginEmpity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.postgresql.translation.messages_cs;


@ManagedBean(name = "LoginMB")
@SessionScoped

public class LoginMB implements Serializable{
    
    private LoginEmpity login;

    public LoginMB() {
        login = new LoginEmpity();
    }
    
    public String LogarNoSistema(){
        if(login.getLogin().equals("Admin") && login.getSenha().equals("Admin")){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("Usuário", login);
            
            return "/aplicacao/index?faces-redirect=true";
        }
        else{
            //TODO Mostrar Mensagem de Usuário não autenticado
            return "/seguranca/login?faces-redirect=true";
         
                   
    } 
    }
    
    public String logout(){
       FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
       return "/seguranca/login?faces-redirect=false";
    }
    

    public LoginEmpity getLogin() {
        return login;
    }

    public void setLogin(LoginEmpity login) {
        this.login = login;
    }
}
