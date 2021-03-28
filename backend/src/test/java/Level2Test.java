import Entities.*;
import Services.CompanyService;
import Services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class Level2Test {

    private UserService userService = new UserService();

    private CompanyService companyService = new CompanyService();

    @Test
    public void successfullDistributionOfMealVoucher() {
        // Given
        User userA = new User(new Account());
        Company company = new Company("Wedoogift",1000, new ArrayList<>(Arrays.asList(userA)));
        MealVoucher mealVoucher = new MealVoucher(LocalDate.now(), 100);
        String returnMessage;

        // When
        returnMessage = companyService.distributeMealVoucherToUser(company, userA ,mealVoucher);

        // Then
        Assert.assertEquals("MealVoucher Successfully distributed !", returnMessage);
        Assert.assertEquals(900, company.getBalance());
        Assert.assertEquals(100, userService.calculateUserBalanceOfMealVouchers(userA));
    }

    @Test
    public void companyBalanceDoesntAllowDistributionOfMealVoucher() {
        // Given
        User userA = new User(new Account());
        Company company = new Company("Wedoogift", 50, new ArrayList<>(Arrays.asList(userA)));
        MealVoucher mealVoucher = new MealVoucher(LocalDate.now(), 100);
        String returnMessage;

        // When
        returnMessage = companyService.distributeMealVoucherToUser(company, userA ,mealVoucher);

        // Then
        Assert.assertEquals("The company cannot afford That MealVoucher!", returnMessage);
        Assert.assertEquals(50, company.getBalance());
        Assert.assertEquals(0, userService.calculateUserBalanceOfMealVouchers(userA));
    }

    @Test
    public void calculateUserBalanceForValideMealVouchers() {
        // Given
        User userA = new User(new Account());
        Company company = new Company("Wedoogift", 1000, new ArrayList<>(Arrays.asList(userA)));
        MealVoucher mealVoucher1 = new MealVoucher(LocalDate.now(), 100);
        MealVoucher mealVoucher2 = new MealVoucher(LocalDate.now(), 200);
        MealVoucher mealVoucher3 = new MealVoucher(LocalDate.now(), 150);

        // When
        companyService.distributeMealVoucherToUser(company, userA ,mealVoucher1);
        companyService.distributeMealVoucherToUser(company, userA ,mealVoucher2);
        companyService.distributeMealVoucherToUser(company, userA ,mealVoucher3);

        // Then
        Assert.assertEquals(550, company.getBalance());
        Assert.assertEquals(450, userService.calculateUserBalanceOfMealVouchers(userA));
    }

    @Test
    public void calculateUserBalanceForInvalideMealVouchers() {
        // Given
        User userA = new User(new Account());
        Company company = new Company("Wedoogift", 500, new ArrayList<>(Arrays.asList(userA)));
        MealVoucher mealVoucher1 = new MealVoucher(LocalDate.now(), 100);
        MealVoucher mealVoucher2 = new MealVoucher(LocalDate.of(2020, Month.JANUARY, 1), 200);
        MealVoucher mealVoucher3 = new MealVoucher(LocalDate.now(), 150);

        // When
        companyService.distributeMealVoucherToUser(company, userA ,mealVoucher1);
        companyService.distributeMealVoucherToUser(company, userA ,mealVoucher2);
        companyService.distributeMealVoucherToUser(company, userA ,mealVoucher3);

        // Then
        Assert.assertEquals(250, userService.calculateUserBalanceOfMealVouchers(userA));
        Assert.assertEquals(50, company.getBalance());
    }
}
