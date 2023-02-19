package org.spring.interceptor.app.repository.nodb;

import org.spring.interceptor.app.entity.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardRepository {
    private static final List<Card> cardList;

    static {
        cardList = new ArrayList<>();
    }

    public List<Card> getCardList() {
        return cardList;
    }
    public Card save(Card card) {
        int size = cardList.size();
        card.setId(String.valueOf(++size));
        cardList.add(card);
        return card;
    }

    public boolean isCardByCustomerNoByLimit3(String customerNo) {
        long count = getCardList().stream()
                .filter((Card card) -> card.getCustomerNo().equals(customerNo))
                .count();
        return count>3;
    }
}
