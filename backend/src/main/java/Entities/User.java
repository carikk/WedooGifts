package Entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class User {

    private Account account;

    public User(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public long calculateUserBalance() {
        long userBalance = 0;
        if (this.getAccount().getGiftCards() != null){
            for (GiftCard gC :
                    this.getAccount().getGiftCards()) {
                if (ChronoUnit.DAYS.between(gC.getDateofRecept(), LocalDate.now()) < 365) {
                    userBalance += gC.getAmountOfGift();
                }
            }
        }

        return userBalance;
    }
}
