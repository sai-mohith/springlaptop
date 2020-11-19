package com.laptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptop.exception.LaptopNotFoundException;
import com.laptop.model.Laptop;
import com.laptop.service.LaptopService;
@RestController
@RequestMapping("laptop-api")
public class LaptopController {
	@Autowired
	LaptopService laptopService;
	@PostMapping("/laptops")
	Laptop addlaptop(@RequestBody Laptop laptop) {
		return laptopService.addlaptop(laptop);
		
	}
	@DeleteMapping("/laptops/delete-one/{laptopId}")

    boolean deleteLaptop(@PathVariable("laptopId")Integer laptopid) throws LaptopNotFoundException {
		return laptopService.deletelaptop(laptopid);
		
	}
	@GetMapping("/laptops/get-one/{laptopId}")

    Laptop getLaptopById(@PathVariable("laptopId")Integer laptopid) throws LaptopNotFoundException {
		return laptopService.getlaptopById(laptopid);
		
	}
	@PutMapping("/laptops/update-one")
    Laptop updateLaptop(Laptop laptop){
    	return laptopService.updatelaptop(laptop);
    	
    }
    @GetMapping("/laptops")


    List<Laptop> getAllLaptops(){
    	return laptopService.getAlllaptops();
    }
    @GetMapping("/laptops/author/{author}")

    List<Laptop> getlaptopbyAuthor(@PathVariable("model")String model) throws LaptopNotFoundException{
    	return laptopService.getLaptopbyCategory(model);
    }
    @GetMapping("/laptops/category/{category}")

    List<Laptop> getlaptopbycategory(@PathVariable("category")String category)throws LaptopNotFoundException{
    	return laptopService.getLaptopbyCategory(category);
    }
    @GetMapping("/laptops/titleauthor/{title}/{author}")

    public List<Laptop> findByModelAndName(@PathVariable("model")String model,@PathVariable("name")String name) throws LaptopNotFoundException{
    	return laptopService.findByModelAndName(model,name);
    }
    @GetMapping("/laptops/titleprice/{title}/{price}")

    public List<Laptop> findlaptopsByModelAndPrice (@PathVariable("model")String model,@PathVariable("price")Double price)throws LaptopNotFoundException{
    	return laptopService.findLaptopsByModelAndPricelaptops(model,price);
    }

}
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bookapp.exception.BookNotFoundException;
//import com.bookapp.model.Book;
//import com.bookapp.service.BookService;
////@RestController
////@RequestMapping("book-api")
//public class BookController {
//	@Autowired
//	BookService bookService;
//	@PostMapping("/books")
//	Book addBook(@RequestBody Book book) {
//		return bookService.addBook(book);
//		
//	}
//	@DeleteMapping("/books/delete-one/{bookId}")
//
//    boolean deleteBook(@PathVariable("bookId")Integer bookid) throws BookNotFoundException {
//		return bookService.deleteBook(bookid);
//		
//	}
//	@GetMapping("/books/get-one/{bookId}")
//
//    Book getBookById(@PathVariable("bookId")Integer bookid) throws BookNotFoundException {
//		return bookService.getBookById(bookid);
//		
//	}
//	@PutMapping("/books/update-one")
//    Book updateBook(Book book){
//    	return bookService.updateBook(book);
//    	
//    }
//    @GetMapping("/books")
//
//
//    List<Book> getAllBooks(){
//    	return bookService.getAllBooks();
//    }
//    @GetMapping("/books/author/{author}")
//
//    List<Book> getBookbyAuthor(@PathVariable("author")String author) throws BookNotFoundException{
//    	return bookService.getBookbyAuthor(author);
//    }
//    @GetMapping("/books/category/{category}")
//
//    List<Book> getBookbycategory(@PathVariable("category")String category)throws BookNotFoundException{
//    	return bookService.getBookbycategory(category);
//    }
//    @GetMapping("/books/titleauthor/{title}/{author}")
//
//    public List<Book> findByTitleAndAuthor(@PathVariable("title")String title,@PathVariable("author")String author) throws BookNotFoundException{
//    	return bookService.findByTitleAndAuthor(title,author);
//    }
//    @GetMapping("/books/titleprice/{title}/{price}")
//
//    public List<Book> findBooksByTitleAndPrice (@PathVariable("title")String title,@PathVariable("price")Double price)throws BookNotFoundException{
//    	return bookService.findBooksByTitleAndPriceBooks(title,price);
//    }
//
//}
