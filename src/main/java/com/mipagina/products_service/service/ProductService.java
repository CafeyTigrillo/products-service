package com.mipagina.products_service.service;

import com.mipagina.products_service.model.Product;
import com.mipagina.products_service.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id_product) {
        productRepository.deleteById(id_product);
    }

    @Override
    public Product findProduct(Long id_product) {
        return productRepository.findById(id_product).orElse(null);
    }

    @Override
    public void editProduct(Long id_product, Product product) {
        Product findProduct=this.findProduct(id_product);
        findProduct.setId_product(id_product);
        findProduct.setName(product.getName());
        findProduct.setDescription(product.getDescription());
        findProduct.setPrice(product.getPrice());
        findProduct.setId_category(product.getId_category());
        findProduct.setAvailability(product.getAvailability());
        this.saveProduct(findProduct);

    }

    @Override
    public List<Product> getProductsByCategory(Long id_category) {
        return productRepository.findProductsByCategoryId(id_category);
    }
}
