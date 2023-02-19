package org.spring.interceptor.app.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.spring.interceptor.app.dto.CardDto;
import org.spring.interceptor.app.entity.Card;

@Mapper
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    Card toEntity(CardDto cardDto);
    CardDto toDto(Card card);
}
