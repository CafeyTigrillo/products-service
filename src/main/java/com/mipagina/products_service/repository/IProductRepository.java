package com.mipagina.products_service.repository;


import com.mipagina.products_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE p.id_category=:id_category")
    List<Product> findProductsByCategoryId(Long id_category);
}
