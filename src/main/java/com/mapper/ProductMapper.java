package com.mapper;

import java.util.List;
import java.util.Map;

import com.entitys.Product;

public interface ProductMapper {
	public Product selectOne(int id);
	public List<Product> selectAll(Map<String,Object> cond);
}
