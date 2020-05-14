package com.library.library.domain;

import com.library.library.domain.enums.BookStatus;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BooksDto {
    private Long id;
    private Long bookSignatureId;
    private String title;

    @Enumerated(EnumType.STRING)
    private BookStatus status;
}
