package com.library.library.controller;

import com.library.library.domain.BookSignatureDto;
import com.library.library.service.BookSignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class BookSignatureController {
    private final BookSignatureService service;

    @Autowired
    public BookSignatureController(BookSignatureService service) {
        this.service = service;
    }

    @GetMapping(value = "/bookSignatures")
    public List<BookSignatureDto> getBookSignatures() {
        return service.getBookSignatures();
    }

    @GetMapping(value = "/bookSignatures/{signatureId}")
    public BookSignatureDto getBookSignatureById(@RequestParam Long signatureId) {
        return service.getBookSignatureById(signatureId);
    }

    @DeleteMapping(value = "/bookSignatures/{signatureId}")
    public void deleteBookSignature(@RequestParam Long signatureId) {
        service.deleteBookSignatureById(signatureId);
    }

    @PostMapping(value = "/bookSignatures")
    public void createBookSignature(@RequestBody BookSignatureDto bookSignatureDto) {
        service.createBookSignature(bookSignatureDto);
    }

    @PutMapping(value = "/bookSignatures")
    public BookSignatureDto updateBookSignature(@RequestBody BookSignatureDto bookSignatureDto) {
        return service.updateBookSignature(bookSignatureDto);
    }
}
