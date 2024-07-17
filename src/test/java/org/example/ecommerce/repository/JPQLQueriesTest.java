package org.example.ecommerce.repository;

import org.example.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;


    @Test
    void findByNameOrDescriptionJPQLIndexParamMethod() {

        Product product=productRepository.findByNameOrDescriptionJPQLIndexParam("product 1",
                "product 2 description");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }


    @Test
    void findByNameOrDescriptionJPQLNamedParamMethod() {

        Product product=productRepository.findByNameOrDescriptionJPQLNamedParam("product 1",
                "product 2 description");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }






}
