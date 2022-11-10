package com.hackerrank.eshopping.product.dashboard;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;

interface productRepository extends JpaRepository<Model,Long>{

}

