package com.mipagina.products_service.service;

import com.mipagina.products_service.model.Product;

import java.util.List;

public interface IProductService {

    public List<Product> getAllProducts();
    public void saveProduct(Product product);
    public void deleteProduct(Long id_product);
    public Product findProduct(Long id_product);
    public void editProduct(Long id_product,Product product);

    public List<Product> getProductsByCategory(Long id_category);
}
