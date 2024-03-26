package com.springbootProject.ProductsManagement.Service;

import com.springbootProject.ProductsManagement.Model.Product;
import com.springbootProject.ProductsManagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private Product product;
    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(int id) {
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            product.setName("");
            product.setId(0);
            product.setType("");
            product.setCost(0);
            return product;
        }
    }


    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product createProduct(@RequestBody Product newProduct){
        return productRepository.save(newProduct);
    }

    public Product updateProduct(@PathVariable int id, @RequestBody Product updateProduct){
        Optional<Product> optional = productRepository.findById(id);
        Product newProduct = new Product();
        if(optional.isPresent()){
            newProduct.setName(updateProduct.getName());
            newProduct.setType(updateProduct.getType());
            newProduct.setCost(updateProduct.getCost());
            return productRepository.save(newProduct);
        }else{
            return productRepository.save(updateProduct);
        }

//        if(productRepository.existsById(id)){
//            updateProduct.setId(id);
//            productRepository.save(updateProduct);
//            return "Product Updated Successfully";
//        }
//        return "Product not found";
    }

    public String deleteProduct(int id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "Product Removed Successfully";
        }
        return "Product not found";

    }
}