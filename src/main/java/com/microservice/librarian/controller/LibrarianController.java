package com.microservice.librarian.controller;

import com.microservice.librarian.entity.Book;
import com.microservice.librarian.entity.dto.BookDTO;
import com.microservice.librarian.mapper.BookMapper;
import com.microservice.librarian.service.LibrarianService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class LibrarianController {

//    @Autowired

//    private final UserRepository userRepository;
    @Autowired
    private LibrarianService librarianService;

//    @GetMapping("/profile")
//    public String readerMainPage() {
//        List<Book> books = librarianService.findAllBooks();
//        model.addAttribute("books", books);
//        model.addAttribute("book", new Book());
//        return "librarian/main_page";
//    }
//
//    @GetMapping("/booking")
//    public String redirectToBooking() {
//        model.addAttribute("book", new Book());
//        return "librarian/add_book";
//    }
//
//    @GetMapping("/editing")
//    public String redirectEditing() {
//        List<Book> books = librarianService.findAllBooks();
//        model.addAttribute("books", books);
//        return "librarian/editing_books";
//    }
//
//    @PostMapping("/add_book")
//    public String addBook(Book book) {
//        librarianService.addBook(book);
//        return "redirect:/librarian/profile";
//    }
//
//    @RequestMapping("/delete/{id}")
//    public String deleteBook(@PathVariable(name = "id") Long id) {
//        librarianService.deleteBookById(id);
//        return "redirect:/librarian/profile";
//    }
//
    @GetMapping("/edit/{id}")
    public @ResponseBody BookDTO updateRedirectBook(@PathVariable(name = "id") Long id) {
        return librarianService.findById(id);
    }
//
//    @PostMapping("/update/{id}")
//    public String updateBook(Book book) {
//        librarianService.updateBook(book);
//        return "redirect:/librarian/profile";
//    }

}
