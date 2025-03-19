package com.devsuperior.dscommerce.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query("SELECT obj FROM Product obj " 
        +   "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%',:name, '%')) ")
    Page<Product> searchByName(String name, org.springframework.data.domain.Pageable pageable);

}
