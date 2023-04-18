package com.microservice.librarian.mapper;

import com.microservice.librarian.entity.Book;
import com.microservice.librarian.entity.dto.BookDTO;
import com.microservice.librarian.service.LibrarianService;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring", uses= LibrarianService.class)
public interface BookMapper {

    BookDTO bookToBookDTO(Book book);


}
