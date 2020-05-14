package com.library.library.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentsDto {
    private int readerId;
    private int bookId;
    private final LocalDate rentDate = LocalDate.now();
    private LocalDate returnDate;
}
