package com.microservice.librarian.mapper;

import com.microservice.librarian.entity.Book;
import com.microservice.librarian.entity.dto.BookDTO;
import com.microservice.librarian.service.LibrarianService;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface BookMapper {

    BookDTO bookToBookDTO(Book book);

    Book bookDTOToBook(BookDTO bookDTO);

    List<BookDTO> booksToBookDTOs(List<Book> books);
}
