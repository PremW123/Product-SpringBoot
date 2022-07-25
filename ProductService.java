package com.productmicroservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.productmicroservice.Model.Product;
import com.productmicroservice.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository prodRe;
	
	//Retrieve Data From DataBase.. 
	public List<Product> listShow(){
		return prodRe.findAll();
	}
	
	//Save Data To DataBase..
	public void saveData(Product product){
	    prodRe.save(product);
	}
	
	//Delete Data From DataBase
	public void delete(int ID){
		prodRe.deleteById(ID);
	}
	
	//Update Data and Retrieve From DataBase
	public Product updateData(int ID){
		return prodRe.findById(ID).get();
	}
	
	//Search Data And Get Data From DataBase
	public List<Product> listAll(String keyword) {
        if (keyword != null) {
            return prodRe.search(keyword);
        }
        return prodRe.findAll();
    }

}
