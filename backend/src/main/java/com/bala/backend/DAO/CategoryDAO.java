package com.bala.backend.DAO;

import java.util.List;

import com.bala.backend.model.Category;

public interface CategoryDAO 
{
	boolean createCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(Category category);
	List<Category> selectAllCategory();
	Category selectOneCategory(int category_Id);
}
