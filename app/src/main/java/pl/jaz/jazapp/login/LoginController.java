package pl.jaz.jazapp.login;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController {
    public String login(LoginRequest loginRequest) {
        System.out.println("Tried to log in" + loginRequest.toString());

        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("error-message", "Incorrect username or password");
        return "/login.xhtml?faces-redirect=true";
    }
}
