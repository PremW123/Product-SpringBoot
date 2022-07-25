package com.productmicroservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.productmicroservice.Model.Product;
import com.productmicroservice.Services.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService prodSe;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/productList")
	public String showAll(Model model, @Param("keyword") String keyword) {
		List<Product> listProduct = prodSe.listAll(keyword);
		model.addAttribute("listProduct", listProduct);
		 model.addAttribute("keyword", keyword);
		return "productList";
	}

	@GetMapping("/addProduct")
	public String saveData(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}

	@PostMapping("/productList")
	public String save(Product product) {
		prodSe.saveData(product);
		return "redirect:/productList";
	}

	@GetMapping("/delete/{ID}")
	public String Delete(@PathVariable(name = "ID") int ID) {
		prodSe.delete(ID);
		return "redirect:/productList";
	}

	@GetMapping("/updateProduct/{ID}")
	public ModelAndView updateData(@PathVariable(name = "ID") int ID) {
		ModelAndView mav = new ModelAndView("updateProduct");
		Product product = prodSe.updateData(ID);
		mav.addObject("product", product);
		return mav;
	}

	@GetMapping("/home")
	public String honme() {
		return "home";
	}
}
