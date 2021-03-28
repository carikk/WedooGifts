package Services;

import Entities.GiftCard;
import Entities.MealVoucher;
import Entities.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UserService {

    public long calculateUserBalance(User user) {
        long userBalance = 0;
        if (user.getAccount().getGiftCards() != null){
            for (GiftCard gC :
                    user.getAccount().getGiftCards()) {
                if (ChronoUnit.DAYS.between(gC.getDateofRecept(), LocalDate.now()) < 365) {
                    userBalance += gC.getAmountOfGift();
                }
            }
        }
        return userBalance;
    }

    public long calculateUserBalanceOfMealVouchers(User user) {
        long userBalance = 0;
        if (user.getAccount().getMealVouchers() != null){
            for (MealVoucher mealVoucher :
                    user.getAccount().getMealVouchers()) {
                if (LocalDate.now().isBefore(mealVoucher.getEndDate())) {
                    userBalance += mealVoucher.getAmountOfVoucher();
                }
            }
        }
        return userBalance;
    }
}
