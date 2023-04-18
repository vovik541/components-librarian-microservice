package com.microservice.librarian.controller;

import com.microservice.librarian.entity.Book;
import com.microservice.librarian.entity.dto.BookDTO;
import com.microservice.librarian.mapper.BookMapper;
import com.microservice.librarian.response.BooksListResponse;
import com.microservice.librarian.service.LibrarianService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;

    @GetMapping("/profile")
    public @ResponseBody BooksListResponse readerMainPage() {
        return librarianService.findAllBooks();
    }

    @GetMapping("/editing")
    public BooksListResponse redirectEditing() {
        return librarianService.findAllBooks();
    }

    @PostMapping("/add_book")
    public @ResponseBody BookDTO addBook(@RequestBody BookDTO book) {
        return librarianService.addBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody void deleteBook(@PathVariable(name = "id") Long id) {
        librarianService.deleteBookById(id);
    }

    @GetMapping("/edit/{id}")
    public @ResponseBody BookDTO updateRedirectBook(@PathVariable(name = "id") Long id) {
        return librarianService.findById(id);
    }

    @PostMapping("/update/{id}")
    public @ResponseBody void updateBook(BookDTO book) {
        librarianService.updateBook(book);
    }

}
