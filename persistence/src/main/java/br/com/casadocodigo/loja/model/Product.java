package br.com.casadocodigo.loja.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product extends BaseEntity<Long>{

    @NotBlank
    private String title;

    @NotBlank
    @Lob
    private String description;
    @Min(30)
    private Integer pages;

//    @ElementCollection
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Price> prices = new ArrayList<>();

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate releaseDate;

    private String summaryPath;

    public Product() {
    }

    public Product(String title, String description, Integer pages, List<Price> prices, LocalDate releaseDate, String summaryPath) {
        this.title = title;
        this.description = description;
        this.pages = pages;
        this.prices = prices;
        this.releaseDate = releaseDate;
        this.summaryPath = summaryPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSummaryPath() {
        return summaryPath;
    }

    public void setSummaryPath(String summaryPath) {
        this.summaryPath = summaryPath;
    }

    public BigDecimal priceFor(BookType bookType) {
        return prices
                .stream()
                .filter(price -> price.getBookType().equals(bookType))
                .findFirst().get().getValue();
    }

}
