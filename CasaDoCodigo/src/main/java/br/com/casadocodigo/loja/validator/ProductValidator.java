package br.com.casadocodigo.loja.validator;

import br.com.casadocodigo.loja.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required");

        Product product = (Product) o;

        if (product.getPages() <= 0){
            errors.rejectValue("pages", "field.required");
        }
    }
}
