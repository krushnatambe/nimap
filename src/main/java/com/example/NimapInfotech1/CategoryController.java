package com.example.NimapInfotech1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class CategoryController {

	public class ProductController {
	    
		@Autowired
		CategoryRepo categoryRepo;
		
		@GetMapping("/categories?page=3")
		public ResponseEntity<List<Category>>getAllCategory(@RequestParam(required=false)String name){
			try {
				List<Category> categories = new ArrayList<Category>();
				if(name == null)
					categoryRepo.findAll().forEach(categories::add);
				else
					categoryRepo.findByCName(name).forEach(categories::add);
				if (categories.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(categories,HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/categories/{id}")
		public ResponseEntity<Category> getCategoryById(@PathVariable("id")long id){
			Optional<Category> categorysdata = categoryRepo.findById(id);
			if (categorysdata.isPresent()) {
				return new ResponseEntity<>(categorysdata.get(),HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		@PostMapping("/categories")
		public ResponseEntity<Category> createProduct(@RequestBody Category category){
			try {
				Category category1 = categoryRepo.save(new Category(category.getName(),category.getDescription(),4041l));
				
				return new ResponseEntity<>(category1,HttpStatus.CREATED);
			} catch (Exception e) {
			    return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PutMapping("/categories/{id}")
		
		public ResponseEntity<Category>updateCategory(@PathVariable("id")long id,@RequestBody Category category){
			Optional<Category>productdata = categoryRepo.findById(id);
			if(productdata.isPresent()) {
		    Category category1 = productdata.get();
		    category1.setName(category.getName());
		    category1.setDescription(category.getDescription());
		    category1.setsectionid(category.getsectionid());
			return new ResponseEntity<>(categoryRepo.save(category1),HttpStatus.OK);
		}else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}
	    @DeleteMapping("/categories/{id}")
	    public ResponseEntity <HttpStatus> deleteCategory(@PathVariable("id")long id){
	    	try {
	    		categoryRepo.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				
			} catch (Exception e) {
			     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }
}
}