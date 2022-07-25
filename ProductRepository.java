package com.productmicroservice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.productmicroservice.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("SELECT p FROM Product p WHERE CONCAT(p.prodName, p.prodType, p.prodCategory, p.prodPrice) LIKE %?1%")
	public List<Product> search(String keyword);

}
