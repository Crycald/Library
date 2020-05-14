package com.library.library.domain;

import com.library.library.domain.enums.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "BOOKS")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(nullable = false, name = "TITLE")
    private String title;

    @Column(name = "STATUS")
    private BookStatus status;
}
