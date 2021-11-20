package service.cardService;

import module.Card;

import java.util.List;

public interface ICardService {
    List<Card> selectAllCard();
    Card selectCardByID(int id);
     void createCard(Card card);
     void updateCard(int id);
     void deleteCard(Card card);
}
