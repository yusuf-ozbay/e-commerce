package org.example.ecommerce.repository;

import org.example.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public Product findByName(String name);

    Optional<Product> findById(Long id);

    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameAndDescription(String name, String description);

    Product findDistinctByName(String name);

     List<Product> findByPriceGreaterThan(BigDecimal price);
     List<Product> findByPriceLessThan(BigDecimal price);


     List<Product> findByNameContaining(String name);
     List<Product> findByNameLike(String name);
    List<Product> findByPriceBetween(BigDecimal startPrice,BigDecimal endPrice);

    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);


    List<Product> findByNameIn(List<String> names);

    @Query("SELECT p from Product p where p.name= ?1 or p.description=?2" )
    Product findByNameOrDescriptionJPQLIndexParam(String name, String description);

    @Query("SELECT p from Product p where p.name= :name or p.description= :description" )
    Product findByNameOrDescriptionJPQLNamedParam(@Param("name") String name,
                                                  @Param("description")  String description);


    @Query(value = "SELECT * from Product p where p.name = ?1 or p.description = ?2",nativeQuery = true )
    Product findByNameOrDescriptionSQLIndexParam(String name, String description);


    @Query(value = "SELECT * from Product p where p.name= :name or p.description= :description",nativeQuery = true )
    Product findByNameOrDescriptionSQLNamedParam(@Param("name") String name,
                                                  @Param("description")  String description);


    Product findByPrice(BigDecimal price);

    List<Product> findAllOrderByNameDesc();

    @Query(nativeQuery = true)
    Product findByDescription(String description);

    List<Product> findAllOrderByNameAsc();


}
