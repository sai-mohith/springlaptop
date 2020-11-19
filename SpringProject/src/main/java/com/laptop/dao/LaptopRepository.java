package com.laptop.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.laptop.model.Laptop;

@Repository
	public interface LaptopRepository extends MongoRepository<Laptop, Integer> {
		
		 List<Laptop>findByModel(String model);
		 List<Laptop>findByCategoryOrderByTitleAsc(String category);
		 List<Laptop> findByModelAndname(String model,String name);
		
		
		@Query("from Laptop b where b.model=?1 and b.price>?2")
		
		
		List<Laptop> findLaptopsByModelAndPricelaptops(String model,Double price);
		
		

	}


