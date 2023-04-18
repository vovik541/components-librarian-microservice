package com.microservice.librarian.response;


import com.microservice.librarian.entity.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BooksListResponse {

    private List<BookDTO> books;


}
