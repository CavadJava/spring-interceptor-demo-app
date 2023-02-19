package org.spring.interceptor.app.service;

import lombok.RequiredArgsConstructor;
import org.spring.interceptor.app.dto.CardDto;
import org.spring.interceptor.app.entity.Card;
import org.spring.interceptor.app.mapper.CardMapper;
import org.spring.interceptor.app.repository.nodb.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CardService {
    private final CardRepository cardRepository;
    public Card create(CardDto cardDto) {
        Card card = CardMapper.INSTANCE.toEntity(cardDto);
        return cardRepository.save(card);
    }
    public List<CardDto> getAllCards() {
        return cardRepository.getCardList().stream().map(CardMapper.INSTANCE::toDto).collect(Collectors.toList());
    }
}
