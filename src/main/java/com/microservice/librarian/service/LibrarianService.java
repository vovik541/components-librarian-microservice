package com.microservice.librarian.service;

import com.microservice.librarian.entity.Book;
import com.microservice.librarian.entity.dto.BookDTO;
import com.microservice.librarian.mapper.BookMapper;
import com.microservice.librarian.repository.BookRepository;
import com.microservice.librarian.response.BooksListResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
@AllArgsConstructor
public class LibrarianService {

    @Autowired
    private BookMapper mapper;
    @Autowired
    private BookRepository bookRepository;

    public BookDTO addBook(BookDTO book){
        return mapper.bookToBookDTO(bookRepository.save(mapper.bookDTOToBook(book)));
    }
    public BooksListResponse findAllBooks() {
        return new BooksListResponse(mapper.booksToBookDTOs(bookRepository.findAll()));
    }

    public BookDTO findById(Long id){
        return mapper.bookToBookDTO(bookRepository.findById(id).get());
    }
    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

    public void updateBook(BookDTO book){
        bookRepository.save(mapper.bookDTOToBook(book));
    }

}
