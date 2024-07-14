package org.example.ecommerce.repository;

import org.example.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.LongConsumer;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //create Product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        //save productt
        Product savedObject = productRepository.save(product);

        //display
        System.out.println(savedObject);
        System.out.println(savedObject.toString());

    }


    @Test
    void updateUsingSaveMethod() {
        //ilk olarak DB de kayılı olan productı idsine göre getireceğiz
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        //aldığımız productu güncelleyeceğiz

        product.setName("updated product 1");
        product.setDescription("updated product 1 desc");
        //daha sonra güncellediğimiz product DBye kaydedeceğiz
        productRepository.save(product);
    }

    @Test
    void findByIdMethod() {

        Long id = 1L;
        productRepository.findById(id).get();

    }

    @Test
    void saveAllMethod() {

        //create Product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 2 description");
        product.setSku("100ABCgD");
        product.setPrice(new BigDecimal(2000));
        product.setActive(true);
        product.setImageUrl("prodguct2.png");
        //create Product
        Product product3 = new Product();
        product3.setName("product 4");
        product3.setDescription("product 4 description");
        product3.setSku("100ABCdDEgFG");
        product3.setPrice(new BigDecimal(3000));
        product3.setActive(true);
        product3.setImageUrl("productg4.png");
        productRepository.saveAll(List.of(product, product3));
    }
    @Test
    void  findAllMethod(){

        List<Product> products =productRepository.findAll();
        products.forEach((product -> {
            System.out.println(product.getName());
        }));

    }

    @Test
    void deleteByIdMethod() {

        Long id = 1L;
        productRepository.deleteById(id);

    }


    @Test
    void deleteMethod() {
        Long id = 7L;
        Product product  = productRepository.findById(id).get();
        productRepository.delete(product);

    }


    @Test
    void deleteAllMethod() {


     productRepository.deleteAll();



    }

    @Test
     void countMethod(){
        Long count=productRepository.count();
        System.out.println(count);

    }

    @Test
    void existByIdMethod(){

        Long id=15L;
        boolean resault=productRepository.existsById(id);
        System.out.println(resault);

    }



}