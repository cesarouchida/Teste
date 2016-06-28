package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.dao.ProductDAO;
import br.com.casadocodigo.loja.model.BookType;
import br.com.casadocodigo.loja.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {

    private final Logger logger = Logger.getLogger(ProductsController.class.getName());

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(method = RequestMethod.POST, name = "saveProduct")
    public ModelAndView save(@Valid @ModelAttribute("errorProduct") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        logger.log(Level.INFO, "Cadastrando produto " + product);

        if(bindingResult.hasErrors()){
            return form(product);
        }

        productDAO.save(product);
        redirectAttributes.addFlashAttribute("sucesso", "Produto Cadastrado com sucesso");
        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(value= "/form", name="formProduct")
    public ModelAndView form(@ModelAttribute("errorProduct") Product product){
        return new ModelAndView("products/product").addObject("types", BookType.values());
    }

    @RequestMapping(method = RequestMethod.GET, name = "listProduct")
    public ModelAndView list(){
        List<Product> produtos = productDAO.findAll();
        produtos.forEach(product -> logger.log(Level.INFO, product.toString()));

        return new ModelAndView("products/list").addObject("products", produtos);
    }
}
