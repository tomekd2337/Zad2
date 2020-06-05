package pl.jaz.jazapp.controllers.login;

import lombok.extern.slf4j.Slf4j;
import pl.jaz.jazapp.exceptions.UserDoesNotExistException;
import pl.jaz.jazapp.model.User;
import pl.jaz.jazapp.service.UserService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
@Slf4j
public class LoginController {

    @EJB
    private UserService userService;

    public String login(LoginRequest loginRequest) {
        log.info("Tried to log in" + loginRequest.toString());

        User user = null;
        try {
            user = userService.getUserByLogin(loginRequest.getUserName());
        } catch (UserDoesNotExistException e) {
            log.warn("", e);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("error-message", "Wrong username or password.");
        }
        if (user.getPassword().equals(loginRequest.getPassword())) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
            return "/index.html";
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("error-message", "Incorrect username or password");
            return "/login.xhtml?faces-redirect=true";
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
}
