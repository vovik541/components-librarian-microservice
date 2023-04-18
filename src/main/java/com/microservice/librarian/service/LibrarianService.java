package com.microservice.librarian.service;

import com.microservice.librarian.entity.Book;
import com.microservice.librarian.entity.dto.BookDTO;
import com.microservice.librarian.mapper.BookMapper;
import com.microservice.librarian.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibrarianService {

    @Autowired
    private BookMapper mapper;
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public BookDTO findById(Long id){
        return mapper.bookToBookDTO(bookRepository.findById(id).get());
    }
    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

}
