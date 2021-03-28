package Entities;

import java.time.LocalDate;

public class GiftCard {

    private LocalDate dateofRecept;

    private long amountOfGift;

    public LocalDate getDateofRecept() {
        return dateofRecept;
    }

    public void setDateofRecept(LocalDate dateofRecept) {
        this.dateofRecept = dateofRecept;
    }

    public long getAmountOfGift() {
        return amountOfGift;
    }

    public void setAmountOfGift(long amountOfGift) {
        this.amountOfGift = amountOfGift;
    }

    public GiftCard(LocalDate dateofRecept, long amountOfGift) {
        this.dateofRecept = dateofRecept;
        this.amountOfGift = amountOfGift;
    }
}
