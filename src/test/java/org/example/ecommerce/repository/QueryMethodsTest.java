package org.example.ecommerce.repository;

import org.example.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        // Verilen isme sahip ürünü bulur
        Product product = productRepository.findByName("product 1");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod() {
        // Verilen ID'ye sahip ürünü bulur
        Product product = productRepository.findById(21L).get();

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod() {
        // Verilen isim veya açıklamaya sahip ürünleri bulur
        List<Product> products = productRepository.findByNameOrDescription("product 1", "product 2 description");
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findByNameAndDescriptionMethod() {
        // Verilen isim ve açıklamaya sahip ürünleri bulur
        List<Product> products = productRepository.findByNameAndDescription("product 1", "product 2 description");
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findDistinctNameMethod() {
        // Verilen isme sahip benzersiz bir ürünü bulur
        Product product = productRepository.findDistinctByName("product 1");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        // Belirli bir fiyatın üzerindeki ürünleri getirir
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }

    @Test
    void findByPriceLessThanMethod() {
        // Belirli bir fiyatın altındaki ürünleri getirir
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(100));
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }

    @Test
    void findByNameContainingMethod() {
        // İsmi belirli bir kelimeyi içeren ürünleri getirir
        List<Product> products = productRepository.findByNameContaining("4");
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }

    @Test
    void findByNameLikeMethod() {
        // İsmi belirli bir kalıbı (tam eşleşme) içeren ürünleri getirir
        List<Product> products = productRepository.findByNameLike("product 4");
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }

    @Test
    void findByPriceBetweenMethod() {
        // Belirli bir fiyat aralığındaki ürünleri bulur
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(1000), new BigDecimal(4000));
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        });
    }

    @Test
    void findByDateBetweenMethod() {
        // Belirli bir tarih aralığındaki ürünleri bulur
        LocalDateTime startDate = LocalDateTime.of(2024, 7, 14, 9, 7, 31); // Başlangıç tarihi ve saati
        LocalDateTime endDate = LocalDateTime.of(2024, 7, 14, 9, 13, 31);  // Bitiş tarihi ve saati

        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        });
    }

    @Test
    void findByNameInMethod() {
        // Belirtilen isimlere sahip ürünleri getirir
        List<Product> products = productRepository.findByNameIn(List.of("product 4", "product 1"));
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }
}
