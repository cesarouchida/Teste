package br.com.casadocodigo.loja.dao;

import br.com.casadocodigo.loja.model.BookType;
import br.com.casadocodigo.loja.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long>{
    @Query("SELECT SUM(price.value) FROM Product p join p.prices price where price.bookType =:bookType")
    BigDecimal sumPricesPerType(@Param("bookType") BookType bookType);
}
