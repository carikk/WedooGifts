package Entities;

import java.time.LocalDate;

public class MealVoucher {

    private LocalDate startDate;

    private LocalDate endDate;

    private long amountOfVoucher;

    public LocalDate getStatDate() {
        return startDate;
    }

    public void setStatDate(LocalDate statDate) {
        this.startDate = statDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public long getAmountOfVoucher() {
        return amountOfVoucher;
    }

    public void setAmountOfVoucher(long amountOfVoucher) {
        this.amountOfVoucher = amountOfVoucher;
    }

    public MealVoucher(LocalDate startDate, long amountOfVoucher) {
        this.startDate = startDate;
        this.endDate = LocalDate.of(startDate.getYear()+1, 02, 28);
        this.amountOfVoucher = amountOfVoucher;
    }
}
