package com.library.library.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadersDto {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate createdAcc;
}
