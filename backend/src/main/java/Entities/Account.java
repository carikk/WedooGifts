package Entities;

import java.util.List;

public class Account {

    private List<GiftCard> giftCards;

    private List<MealVoucher> mealVouchers;

    public List<GiftCard> getGiftCards() {
        return giftCards;
    }

    public void setGiftCards(List<GiftCard> giftCards) {
        this.giftCards = giftCards;
    }

    public List<MealVoucher> getMealVouchers() {
        return mealVouchers;
    }

    public void setMealVouchers(List<MealVoucher> mealVouchers) {
        this.mealVouchers = mealVouchers;
    }
}
