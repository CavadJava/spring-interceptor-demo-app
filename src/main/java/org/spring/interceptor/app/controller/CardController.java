package org.spring.interceptor.app.controller;

import lombok.RequiredArgsConstructor;
import org.spring.interceptor.app.dto.CardDto;
import org.spring.interceptor.app.entity.Card;
import org.spring.interceptor.app.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping
    public Card save(@RequestBody CardDto cardDto) {
        return cardService.create(cardDto);
    }
    @GetMapping
    public List<CardDto> all() {
        return cardService.getAllCards();
    }
}
