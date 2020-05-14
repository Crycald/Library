package com.library.library.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentsDto {
    private Long rentId;
    private Long readerId;
    private Long bookId;
    private LocalDate rentDate;
    private LocalDate returnDate;
}
