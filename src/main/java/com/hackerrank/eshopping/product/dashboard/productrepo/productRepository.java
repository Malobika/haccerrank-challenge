package com.hackerrank.eshopping.product.dashboard.productrepo;
import com.hackerrank.eshopping.product.dashboard.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

interface productrepo extends JpaRepository<Product,Long>{

}

