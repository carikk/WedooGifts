package Entities;

import java.util.List;

public class Account {

    private List<GiftCard> giftCards;

    public List<GiftCard> getGiftCards() {
        return giftCards;
    }

    public void setGiftCards(List<GiftCard> giftCards) {
        this.giftCards = giftCards;
    }
}
