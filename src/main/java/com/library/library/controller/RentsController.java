package com.library.library.controller;

import com.library.library.domain.RentsDto;
import com.library.library.service.RentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class RentsController {
    private final RentsService service;

    @Autowired
    public RentsController(RentsService service) {
        this.service = service;
    }

    @GetMapping(value = "/rents")
    public List<RentsDto> getRents() {
        return service.getRents();
    }

    @GetMapping(value = "/rents/{rentId}")
    public RentsDto getRentById(@RequestParam Long rentId) {
        return service.getRent(rentId);
    }

    @DeleteMapping(value = "/rents/{rentId}")
    public void deleteRent(@RequestParam Long rentId) {
        service.deleteRent(rentId);
    }

    @PostMapping(value = "/rents")
    public void createRent(@RequestBody RentsDto rentsDto) {
        service.createRent(rentsDto);
    }

    @PutMapping(value = "/rents")
    public RentsDto updateRent(@RequestBody RentsDto rentsDto) {
        return service.updateRent(rentsDto);
    }
}
