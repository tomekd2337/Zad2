package pl.jaz.jazapp.extension.validator;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.PropertyResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("usernameValidator")
public class UsernameValidator implements Validator<String> {

    private Pattern onlySmallLetters = Pattern.compile("[a-z]*");


    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {

        if (!onlySmallLetters.matcher(value).matches()){
            String message = getMsg().getString("pl.jaz.jazapp.webapp.extension.validator.UsernameValidator.ONLY_SMALL_LETTERS");
            throw new ValidatorException(new FacesMessage(message));
        }
    }

    public PropertyResourceBundle getMsg(){
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().evaluateExpressionGet(context,"#{msg}",PropertyResourceBundle.class);
    }
}
