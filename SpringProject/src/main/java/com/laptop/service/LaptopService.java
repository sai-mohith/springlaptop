package com.laptop.service;

import java.util.List;

import com.laptop.exception.LaptopNotFoundException;
import com.laptop.model.Laptop;




public interface LaptopService {
	Laptop addLaptop(Laptop laptop);

    boolean deleteLaptop(Integer laptopid) throws LaptopNotFoundException;

    Laptop getLaptopById(Integer laptopid) throws LaptopNotFoundException;

    Laptop updateLaptop(Laptop laptop);


    List<Laptop> getAllLaptops();

    List<Laptop> getLaptopbyName(String name) throws LaptopNotFoundException;

    List<Laptop> getLaptopbyCategory(String category) throws LaptopNotFoundException;
    List<Laptop> findByModelAndName(String model,String name) ;




	List<Laptop> getLaptopbyModel(String model) throws LaptopNotFoundException;

	
	

	List<Laptop> findLaptopsByModelAndListPricelaptops(String model, Double price);

	List<Laptop> findLaptopsByModelAndPriceLaptops(String model, Double price);

	

	


	

	
}