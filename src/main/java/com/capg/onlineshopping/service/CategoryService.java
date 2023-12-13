package com.capg.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlineshopping.entity.Category;
import com.capg.onlineshopping.exceptions.CategoryAlreadyExistsException;
import com.capg.onlineshopping.exceptions.CategoryIdNotFoundException;
import com.capg.onlineshopping.exceptions.IdNotFoundException;
import com.capg.onlineshopping.repository.CategoryRepository;
import com.capg.onlineshopping.utility.AppConstant;

@Service
public class CategoryService {
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category addCategory(Category category)
	{
		return categoryRepository.save(category);
		
	}
	
	public Category createCategory(Category category) throws CategoryAlreadyExistsException{
		 
		Category existingCategory = categoryRepository.findByName(category.getName().toLowerCase());

		     if(existingCategory != null) 
		     {

			    throw new CategoryAlreadyExistsException(AppConstant.CATEGORY_NAME_ALREADY_EXITS_INFO);

		     }

		          category.setName(category.getName().toLowerCase());

		return categoryRepository.save(category);

	}

	public List<Category> fetchCategory() {
		
		return categoryRepository.findAll();
	}

	public String deleteCategoryById(int cid) {
		String msg="";
		if(categoryRepository.existsById(cid))
		{
			categoryRepository.deleteById(cid);
			msg="Category Deleted Successfully";
		}
		else
		{
			throw new CategoryIdNotFoundException(AppConstant.CATEGORY_ID_NOT_FOUND_INFO);
		}
		return msg;
	}
	
	//public Category fetchCategoryById(int cid) throws ID
	
	
	public Category updateCategoryById(int cid,Category category) throws IdNotFoundException{
		 
		Category new_category = null;

		if(categoryRepository.existsById(cid)) {

			new_category = categoryRepository.findById(cid).get();

			new_category.setName(category.getName().toLowerCase());

			categoryRepository.save(new_category);

		}

		else {

			throw new IdNotFoundException(AppConstant.CATEGORY_ID_NOT_FOUND_INFO);

		}
		return new_category;
}		

}
