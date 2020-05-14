package com.library.library.domain;

import com.library.library.domain.enums.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BooksDto {
    private int id;
    private String title;
    private BookStatus status;
}
