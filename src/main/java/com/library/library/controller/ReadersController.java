package com.library.library.controller;

import com.library.library.domain.BooksDto;
import com.library.library.domain.ReadersDto;
import com.library.library.service.ReadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class ReadersController {
    private final ReadersService service;

    @Autowired
    public ReadersController(ReadersService service) {
        this.service = service;
    }

    @GetMapping(value = "/readers")
    public List<ReadersDto> getReaders() {
        return service.getReaders();
    }

    @GetMapping(value = "/readers/{readerId}")
    public ReadersDto getReaderById(@RequestParam Long readerId) {
        return service.getReader(readerId);
    }

    @DeleteMapping(value = "/readers/{readerId}")
    public void deleteReader(@RequestParam Long readerId) {
        service.deleteReader(readerId);
    }

    @PostMapping(value = "/readers")
    public void createReader(@RequestBody ReadersDto readersDto) {
        service.createReader(readersDto);
    }

    @PutMapping(value = "/readers")
    public ReadersDto updateReader(@RequestBody ReadersDto readersDto) {
        return service.updateReader(readersDto);
    }
}
