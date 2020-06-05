package pl.jaz.jazapp;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;

@SessionScoped
public class UserContext implements Serializable  {


    private static final long serialVersionUID = 1L;

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }




}
