package com.springbootProject.ProductsManagement.Controller;

import com.springbootProject.ProductsManagement.Model.Product;
import com.springbootProject.ProductsManagement.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private Product product;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product newProduct){
        return productService.createProduct(newProduct);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id,@RequestBody Product updateProduct){
        return productService.updateProduct(id,updateProduct);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }

}
