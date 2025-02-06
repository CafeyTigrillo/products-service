package com.mipagina.products_service.controller;

import com.mipagina.products_service.model.Product;
import com.mipagina.products_service.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("/create")
    public String createProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return "Product created successfully";
    }

    @GetMapping("/bring_all")
    public List<Product> bringAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/bring/{id_product}")
    public Product bringProduct(@PathVariable Long id_product){
        return productService.findProduct(id_product);
    }

    @PutMapping("/edit/{id_product}")
    public String editProduct(@PathVariable Long id_product,
                               @RequestBody Product product){
        productService.editProduct(id_product,product);
        return "Product edited successfully";
    }

        @DeleteMapping("/delete/{id_product}")
    public String deleteProduct(@PathVariable Long id_product){
        productService.deleteProduct(id_product);
        return "Product deleted successfully";
    }

    @GetMapping("/{id_category}")
    public List<Product> getProductsByCategoryId(@PathVariable Long id_category){
        return productService.getProductsByCategory(id_category);
    }

}
