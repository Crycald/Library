package com.library.library.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookSignatureDto {
    private Long id;
    private String title;
    private String author;
    private LocalDate publicationDate;
}
