package com.library.library.domain;

import com.library.library.domain.enums.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "BOOKS")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BOOK_SIGNATURE_ID")
    private BookSignature bookSignatureId;

    @Column(nullable = false, name = "BOOK_SIGNATURE_TITLE")
    private BookSignature title;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private BookStatus status;
}
