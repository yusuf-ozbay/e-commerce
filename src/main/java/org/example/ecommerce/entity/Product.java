package org.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
// Bu @NamedQuery annotation'ı, belirli bir fiyata sahip ürünleri bulmak için adlandırılmış bir JPQL sorgusu tanımlar.
//@NamedQuery(
//        name = "product.findByPrice", // Sorguya verilen ad, program içinde kullanılarak sorgunun çağrılmasını sağlar.
//        query = "select p from Product p where p.price = price " // JPQL sorgusu; ?1 placeholder'ı, sorguya parametre olarak geçilecek olan fiyatı temsil eder.
//)


@NamedQueries(   //birden fazla sorgu yazmak sitediğimzide bunu kullanırıız

        {
                @NamedQuery(
                        name = "Product.findAllOrderByNameDesc",    //sorgunun ismi
                        query = "select p from Product p order by p.name DESC "  //isime göre azalan bir şekilde sıralayan sorgu
                ),
                @NamedQuery(
                        name = "Product.findByPRice",
                        query = "select p from Product p where  p.price= :price" // :price paramatere oalrak girdiğimiz fiyata göre üğürnü getiren sorgu


                )
        }

)

//@NamedNativeQuery(
//
//        name = "Product.findByDescription",
//        query = "select * from Product p where p.description= ?1",
//        resultClass = Product.class
//)


@NamedNativeQueries(
        {
                @NamedNativeQuery(
                        name = "Product.findByDescription",
                        query = "select * from product where description = ?1",
                        resultClass = Product.class
                ),
                @NamedNativeQuery(
                        name = "Product.findAllOrderByNameAsc",
                        query = "select * from product order by name ASC",
                        resultClass = Product.class
                )
        }
)

@Table(
        name = "product",
        schema = "e-commerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku-uniqe",
                        columnNames="stock_keeping_unit"
                )
        }
)
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    )
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private long id;



    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;

    @Column(nullable = false)
    private String name;

    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;


}
