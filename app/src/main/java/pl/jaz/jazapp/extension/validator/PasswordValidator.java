package pl.jaz.jazapp.extension.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.PropertyResourceBundle;
import java.util.regex.Pattern;

public class PasswordValidator implements Validator<String> {



        private Pattern onlySmallLetters1 = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])");


        @Override
        public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {

            if (!onlySmallLetters1.matcher(value).matches()){
                String message = getMsg().getString("pl.jaz.jazapp.webapp.extension.validator.UsernameValidator.ONLY_SMALL_LETTERS");
                throw new ValidatorException(new FacesMessage(message));
            }
        }

        public PropertyResourceBundle getMsg(){
            FacesContext context = FacesContext.getCurrentInstance();
            return context.getApplication().evaluateExpressionGet(context,"#{msg}",PropertyResourceBundle.class);
        }

}
