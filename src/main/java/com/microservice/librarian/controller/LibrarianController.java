package com.microservice.librarian.controller;

import com.microservice.librarian.entity.Book;
import com.microservice.librarian.entity.dto.BookDTO;
import com.microservice.librarian.error.NotAllowedBookName;
import com.microservice.librarian.mapper.BookMapper;
import com.microservice.librarian.response.BooksListResponse;
import com.microservice.librarian.service.LibrarianService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1")
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;
    @Operation(summary = "Get all books for profile page")
    @GetMapping("/profile")
    public @ResponseBody BooksListResponse readerMainPage() {
        return librarianService.findAllBooks();
    }
    @Operation(summary = "Get all books for editing")
    @GetMapping("/editing")
    public BooksListResponse redirectEditing() {
        return librarianService.findAllBooks();
    }
    @Operation(summary = "Add new book",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Book added",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = BookDTO.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Not allowed book name",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = NotAllowedBookName.class)
                                    )
                            }
                    )
            })
    @PostMapping("/addBook")
    public @ResponseBody BookDTO addBook(@RequestBody BookDTO book) throws NotAllowedBookName {

        if (book.getBookName().equals("not allowed")){
            throw new NotAllowedBookName();
        }

        return librarianService.addBook(book);
    }
    @Operation(summary = "Delete book by id")
    @DeleteMapping("/delete/{id}")
    public @ResponseBody void deleteBook(@PathVariable(name = "id") Long id) {
        librarianService.deleteBookById(id);
    }
    @Operation(summary = "Get book by id for editing")
    @GetMapping("/edit/{id}")
    public @ResponseBody BookDTO updateRedirectBook(@PathVariable(name = "id") Long id) {
        return librarianService.findById(id);
    }
    @Operation(summary = "Update book by id")
    @PostMapping("/update/{id}")
    public @ResponseBody void updateBook(@RequestBody BookDTO book) {
        librarianService.updateBook(book);
    }

}
