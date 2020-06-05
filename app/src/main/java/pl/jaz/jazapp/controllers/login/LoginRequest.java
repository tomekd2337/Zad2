package pl.jaz.jazapp.controllers.login;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Data
@Named
@RequestScoped
public class LoginRequest {
    private String userName;
    private String password;
}
