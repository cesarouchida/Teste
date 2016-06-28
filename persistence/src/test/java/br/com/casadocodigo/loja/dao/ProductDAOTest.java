package br.com.casadocodigo.loja.dao;

import br.com.casadocodigo.PersistenceApplication;
import br.com.casadocodigo.loja.model.BookType;
import br.com.casadocodigo.loja.model.Price;
import br.com.casadocodigo.loja.model.Product;
import static org.junit.Assert.*;

import br.com.casadocodigo.loja.util.ProductBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(PersistenceApplication.class)
@ActiveProfiles("dev")
@Transactional
public class ProductDAOTest {

    private Logger logger = Logger.getLogger(ProductDAOTest.class.getName());

    @Autowired
    private ProductDAO dao;

    @Test
    public void inserindoProduct(){
        List<Price> listas = new ArrayList<>();
        listas.add(new Price(new BigDecimal(10), BookType.PRINTED));
        listas.add(new Price(new BigDecimal(10), BookType.EBOOK));
        listas.add(new Price(new BigDecimal(30), BookType.COMBO));

        dao.save(new Product("Teste Super", "Testando", 60, listas, LocalDate.now(), "Caminho do Path") );
        dao.findAll().forEach(product -> logger.log(Level.WARNING, product.toString()));
    }

    @Test
    public void listandoProduct(){
        List<Product> products = dao.findAll();
        products.forEach(product -> logger.log(Level.INFO, product.toString()));
        assertEquals(products.get(0).getTitle(), "JAVAEE in Action");
    }

    @Test
    public void shouldSumAllPricesOfEachBookPerType(){
        BigDecimal quantidadeBanco = dao.sumPricesPerType(BookType.PRINTED);

        List<Product> printedBooks = ProductBuilder.newProduct(BookType.PRINTED, BigDecimal.TEN)
                                                    .more(4)
                                                    .buildAll();
        printedBooks.stream().forEach(dao::save);

        List<Product> ebooks = ProductBuilder.newProduct(BookType.EBOOK, BigDecimal.TEN)
                                                    .more(4)
                                                    .buildAll();
        ebooks.stream().forEach(dao::save);

        BigDecimal value = dao.sumPricesPerType(BookType.PRINTED);
        assertEquals(new BigDecimal(50).setScale(2).add(quantidadeBanco), value);
    }
}