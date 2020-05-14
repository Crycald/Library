package com.library.library.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadersDto {
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate createdAcc;
}
