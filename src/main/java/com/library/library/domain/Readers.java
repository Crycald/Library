package com.library.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "READERS")
public class Readers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(nullable = false, name = "FIRSTNAME")
    private String firstname;

    @Column(nullable = false, name = "LASTNAME")
    private String lastname;

    @Column(nullable = false, name = "CREATED_ACC")
    private LocalDate createdAcc;
}
