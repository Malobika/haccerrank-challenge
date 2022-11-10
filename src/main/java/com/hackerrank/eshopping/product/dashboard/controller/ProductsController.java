package com.hackerrank.eshopping.product.dashboard.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.hackerrank.eshopping.product.dashboard.model.Product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.ResponseEntity;


interface ProductRepository extends JpaRepository<Product, Long> {

}

@RestController
@RequestMapping(value = "/products")
public class ProductsController {
  private final ProductRepository repository;
  ProductsController(ProductRepository repository) {
    this.repository = repository;
  }
  
  

  // Single item
  
  @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id, @RequestParam(required = false) String category) {
        ResponseEntity<Product> productResponseEntity;

        Optional<Product> byId = repository.findById(id);

        if (byId.isPresent()) {
            productResponseEntity = new ResponseEntity<>(byId.get(), HttpStatus.OK);
        } else {
            productResponseEntity = new ResponseEntity<>(new Product(), HttpStatus.NOT_FOUND);
        }

        return productResponseEntity;
    }
//Your code above
    //@GetMapping("?category={category}")
    //public List getProductsByCategory(@PathVariable String category){
        //return repository.findByCategory(category);
    //}
    //@GetMapping("?category={category}&availability={availability}")
    //public List getProductsByCategoryAndAvailability(@PathVariable String category, @PathVariable int availability){
        //return repository.findByCategoryAndAvailability(category, availability);
    //}



    @PostMapping
    Product createProduct(@RequestBody Product newProduct) {
        
       
        return repository.findById(newProduct.getId())
                .map(product -> {
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    return repository.save(newProduct);
                });


    }

    @PutMapping("/{id}")
    Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id){
        return repository.findById(id)
                .map(product -> {
                    product.setRetailPrice(newProduct.getRetailPrice());
                    product.setDiscountedPrice(newProduct.getDiscountedPrice());
                    product.setAvailability(newProduct.getAvailability());
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });

    }



    @GetMapping()
        public List getAllProducts(){

            return repository.findAll();
        }

  

}
