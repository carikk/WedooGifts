package Services;

import Entities.Company;
import Entities.GiftCard;
import Entities.MealVoucher;
import Entities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompanyService {

    public String distributeGiftCardToUser(Company company, User user, GiftCard giftCard) {
        if (company.getBalance() > giftCard.getAmountOfGift()) {
            List userGiftCards = user.getAccount().getGiftCards();
            if (userGiftCards != null) {
                userGiftCards.add(giftCard);
            } else {
                userGiftCards = new ArrayList<>(Arrays.asList(giftCard));
            }
            company.setBalance(company.getBalance() - giftCard.getAmountOfGift());
            user.getAccount().setGiftCards(userGiftCards);
        } else {
            return "The company cannot afford That !";
        }
        return "Successfully distributed !";
    }

    public String distributeMealVoucherToUser(Company company, User user, MealVoucher mealVoucher) {
        if (company.getBalance() > mealVoucher.getAmountOfVoucher()) {
            List userMealVouchers = user.getAccount().getMealVouchers();
            if (userMealVouchers != null) {
                userMealVouchers.add(mealVoucher);
            } else {
                userMealVouchers = new ArrayList<>(Arrays.asList(mealVoucher));
            }
            company.setBalance(company.getBalance() - mealVoucher.getAmountOfVoucher());
            user.getAccount().setMealVouchers(userMealVouchers);
        } else {
            return "The company cannot afford That MealVoucher!";
        }
        return "MealVoucher Successfully distributed !";
    }
}
