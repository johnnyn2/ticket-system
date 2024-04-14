package com.ticket.system.controller;

import com.ticket.system.dto.ConcertDTO;
import com.ticket.system.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConcertController {
    @Autowired
    private ConcertService concertService;
    @GetMapping("/concert")
    public ResponseEntity<ConcertDTO> getConcert(@RequestParam String code) {
        return ResponseEntity.ok(concertService.getConcertByCode(code));
    }
}
