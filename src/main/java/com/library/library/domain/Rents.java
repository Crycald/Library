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
@Table(name = "RENTS")
public class Rents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RENT_ID")
    private int rentId;

    @Column(nullable = false, name = "READER_ID")
    private Readers readerId;

    @Column(nullable = false, name = "BOOK_ID")
    private Books bookId;

    @Column(nullable = false, name = "RENT_DATE")
    private final LocalDate rentDate = LocalDate.now();

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;
}
