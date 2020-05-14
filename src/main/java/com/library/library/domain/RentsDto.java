package com.library.library.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentsDto {
    private int rentId;
    private int readerId;
    private int bookId;
    private LocalDate rentDate;
    private LocalDate returnDate;
}
