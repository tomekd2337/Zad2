package pl.jaz.jazapp;

import pl.jaz.jazapp.service.UserService;

import javax.ejb.EJB;
import javax.faces.application.ResourceHandler;
import javax.faces.context.FacesContext;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class SecurityFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (isSiteAllowed(req) || isResourceReq(req) || isUserAuthenticated(req)) {
            chain.doFilter(req, res);
        } else{
            res.sendRedirect(req.getContextPath()+ "/login.xhtml");
        }

    }

    private boolean isUserAuthenticated(HttpServletRequest req) {
        Object user = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        return user != null;
    }

    private boolean isResourceReq (HttpServletRequest req) {
        return req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/"); // 21,00
    }

    private boolean isSiteAllowed(HttpServletRequest req) {
        return "/login.xhtml".equals(req.getServletPath()) || "/register.xhtml".equals(req.getServletPath());
    }
}
