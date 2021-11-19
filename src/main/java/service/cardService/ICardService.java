package service.cardService;

import module.Card;

import java.util.List;

public interface ICardService {
    List<Card> selectAllCard();
    Card selectCardByID();
     void createCard(Card card);
     void upDateCard(Card card);
     void deleteCard(Card card);
}
