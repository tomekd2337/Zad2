package pl.jaz.jazapp.controllers.register;

import lombok.extern.slf4j.Slf4j;
import pl.jaz.jazapp.model.User;
import pl.jaz.jazapp.service.UserService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
@Slf4j
public class RegisterController {
    @EJB
    private UserService userService;
    public String register(RegisterRequest registerRequest) {
        log.info("############" + registerRequest.toString());

        User user = new User();
        user.setLogin(registerRequest.getUserName());
        user.setPassword(registerRequest.getPassword());
        userService.createUser(user);

        return "/login.xhtml?faces-redirect=true";
    }


}
