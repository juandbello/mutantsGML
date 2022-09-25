package com.juandavid.mutantes.mutantes.web.controller;

import com.juandavid.mutantes.mutantes.domain.dto.StatDto;
import com.juandavid.mutantes.mutantes.domain.services.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatController {

    @Autowired
    private StatService statService;

    @GetMapping
    public ResponseEntity<StatDto> get(){
        return new ResponseEntity<>(statService.getStat(), HttpStatus.OK);
    }
}
