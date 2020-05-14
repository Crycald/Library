package com.library.library.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReadersDto {
    private int id;
    private String firstname;
    private String lastname;
    private final LocalDate createdAcc = LocalDate.now();
}
