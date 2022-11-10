package com.hackerrank.eshopping.product.dashboard.productrepo;
import com.hackerrank.eshopping.product.dashboard.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

interface productRepository extends JpaRepository<Product,Long>{

}

