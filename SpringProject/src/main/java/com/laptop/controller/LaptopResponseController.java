package com.laptop.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/laptop-api")
public class LaptopResponseController {
    
    @Autowired
    LaptopService laptopService;

 

    @PostMapping("/laptops")
    ResponseEntity<Laptop> addlaptop(@RequestBody Laptop laptop) {
        Laptop nlaptop = laptopService.addlaptop(laptop);
        return ResponseEntity.ok(nlaptop);
    }
    @DeleteMapping("/laptops/delete-one/{laptopId}")
    ResponseEntity<Void> deletelaptop(@PathVariable("laptopId")Integer laptopid) throws LaptopNotFoundException{
        laptopService.deletelaptop(laptopid);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/laptops/get-one/{laptopId}")
    ResponseEntity<Laptop> getlaptopById(@PathVariable("laptopId")Integer laptopid) throws LaptopNotFoundException{
        Laptop nlaptop = laptopService.getlaptopById(laptopid);
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Getting laptop by Id");
        header.add("title", "One laptop");
        return ResponseEntity.status(HttpStatus.OK)
                .headers(header).body(nlaptop);
    }
    @PutMapping("/laptops/update-one")
    ResponseEntity<Laptop> updatelaptop(Laptop laptop) {
        Laptop nlaptop = laptopService.updatelaptop(laptop);
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Updating laptop");
        header.add("title", "One laptop");
        return ResponseEntity.status(HttpStatus.OK)
                .headers(header).body(nlaptop);
    }
    @GetMapping("/laptops")
    ResponseEntity<List<Laptop>> getAlllaptops(){
        List<Laptop> laptopList =  laptopService.getAlllaptops();
        return ResponseEntity.ok(laptopList);
    }
    @GetMapping("/laptops/author/{model}")
    ResponseEntity<List<Laptop>> getlaptopbyAuthor(@PathVariable("model")String model) throws LaptopNotFoundException{
        List<Laptop> laptopList =   laptopService.getLaptopbyModel(model);
        return ResponseEntity.ok(laptopList);
    }
    @GetMapping("/laptops/category/{category}")
    ResponseEntity<List<Laptop>> getlaptopbycategory(@PathVariable("category")String category){
        List<Laptop> laptopList = laptopService.getLaptopbyCategory(category);    
        return ResponseEntity.ok(laptopList);
    }
    @GetMapping("/laptops/titleauthor/{model}/{name}")
    public ResponseEntity<List<Laptop>> findByModelAndName(@PathVariable("model")String model,
            @PathVariable("name")String name) {
        List<Laptop> laptopList = laptopService.findByModelAndName(model, name);
        return ResponseEntity.ok(laptopList);
        
    }
    @GetMapping("/laptops/titleprice/{title}/{price}")
    public ResponseEntity<List<Laptop>> findlaptopsByTitleAndPrice(@PathVariable("title")String title, 
            @PathVariable("price")double price) {
        List<Laptop> laptopList = laptopService.findlaptopsByModelAndPricelaptops(title, price);
        return ResponseEntity.ok(laptopList);
    }

 

}

//
//import java.util.List;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
// 
//
//import com.bookapp.exception.BookNotFoundException;
//import com.bookapp.model.Book;
//import com.bookapp.service.BookService;
//
// 
//
//@RestController
//@RequestMapping("/book-api")
//public class BookResponseController {
//    
//    @Autowired
//    BookService bookService;
//
// 
//
//    @PostMapping("/books")
//    ResponseEntity<Book> addBook(@RequestBody Book book) {
//        Book nbook = bookService.addBook(book);
//        return ResponseEntity.ok(nbook);
//    }
//    @DeleteMapping("/books/delete-one/{bookId}")
//    ResponseEntity<Void> deleteBook(@PathVariable("bookId")Integer bookid) throws BookNotFoundException{
//        bookService.deleteBook(bookid);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//    @GetMapping("/books/get-one/{bookId}")
//    ResponseEntity<Book> getBookById(@PathVariable("bookId")Integer bookid) throws BookNotFoundException{
//        Book nbook = bookService.getBookById(bookid);
//        HttpHeaders header = new HttpHeaders();
//        header.add("desc", "Getting book by Id");
//        header.add("title", "One Book");
//        return ResponseEntity.status(HttpStatus.OK)
//                .headers(header).body(nbook);
//    }
//    @PutMapping("/books/update-one")
//    ResponseEntity<Book> updateBook(Book book) {
//        Book nbook = bookService.updateBook(book);
//        HttpHeaders header = new HttpHeaders();
//        header.add("desc", "Updating book");
//        header.add("title", "One Book");
//        return ResponseEntity.status(HttpStatus.OK)
//                .headers(header).body(nbook);
//    }
//    @GetMapping("/books")
//    ResponseEntity<List<Book>> getAllBooks(){
//        List<Book> bookList =  bookService.getAllBooks();
//        return ResponseEntity.ok(bookList);
//    }
//    @GetMapping("/books/author/{author}")
//    ResponseEntity<List<Book>> getBookbyAuthor(@PathVariable("author")String author) throws BookNotFoundException{
//        List<Book> bookList =   bookService.getBookbyAuthor(author);
//        return ResponseEntity.ok(bookList);
//    }
//    @GetMapping("/books/category/{category}")
//    ResponseEntity<List<Book>> getBookbycategory(@PathVariable("category")String category){
//        List<Book> bookList = bookService.getBookbycategory(category);    
//        return ResponseEntity.ok(bookList);
//    }
//    @GetMapping("/books/titleauthor/{title}/{author}")
//    public ResponseEntity<List<Book>> findByTitleAndAuthor(@PathVariable("title")String title,
//            @PathVariable("author")String author) {
//        List<Book> bookList = bookService.findByTitleAndAuthor(title, author);
//        return ResponseEntity.ok(bookList);
//        
//    }
//    @GetMapping("/books/titleprice/{title}/{price}")
//    public ResponseEntity<List<Book>> findBooksByTitleAndPrice(@PathVariable("title")String title, 
//            @PathVariable("price")double price) {
//        List<Book> bookList = bookService.findBooksByTitleAndPriceBooks(title, price);
//        return ResponseEntity.ok(bookList);
//    }
//
// 
//
//}
//
