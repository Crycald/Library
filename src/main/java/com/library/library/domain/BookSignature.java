package com.library.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "BOOK_SIGNATURE")
public class BookSignature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(nullable = false, name = "TITLE")
    private String title;

    @Column(nullable = false, name = "AUTHOR")
    private String author;

    @Column(nullable = false, name = "PUBLICATION_DATE")
    private LocalDate publicationDate;
}
