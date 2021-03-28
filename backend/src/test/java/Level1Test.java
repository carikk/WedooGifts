import Entities.Account;
import Entities.Company;
import Entities.GiftCard;
import Entities.User;
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
public class Level1Test {


    private UserService userService = new UserService();

    private CompanyService companyService = new CompanyService();

    @Test
    public void successfullDistribution() {
        // Given
        User userA = new User(new Account());
        Company company = new Company("Wedoogift",1000, new ArrayList<>(Arrays.asList(userA)));
        GiftCard giftCard = new GiftCard(LocalDate.now(), 100);
        String returnMessage;

        // When
        returnMessage = companyService.distributeGiftCardToUser(company, userA ,giftCard);

        // Then
        Assert.assertEquals("Successfully distributed !", returnMessage);
        Assert.assertEquals(900, company.getBalance());
        Assert.assertEquals(100, userService.calculateUserBalance(userA));
    }

    @Test
    public void companyBalanceDoesntAllowDistribution() {
        // Given
        User userA = new User(new Account());
        Company company = new Company("Wedoogift", 50, new ArrayList<>(Arrays.asList(userA)));
        GiftCard giftCard = new GiftCard(LocalDate.now(), 100);
        String returnMessage;

        // When
        returnMessage = companyService.distributeGiftCardToUser(company, userA ,giftCard);

        // Then
        Assert.assertEquals("The company cannot afford That !", returnMessage);
        Assert.assertEquals(50, company.getBalance());
        Assert.assertEquals(0, userService.calculateUserBalance(userA));
    }

    @Test
    public void calculateUserBalanceForValideGiftCards() {
        // Given
        User userA = new User(new Account());
        Company company = new Company("Wedoogift", 1000, new ArrayList<>(Arrays.asList(userA)));
        GiftCard giftCard1 = new GiftCard(LocalDate.now(), 100);
        GiftCard giftCard2 = new GiftCard(LocalDate.now(), 200);
        GiftCard giftCard3 = new GiftCard(LocalDate.now(), 150);

        // When
        companyService.distributeGiftCardToUser(company, userA ,giftCard1);
        companyService.distributeGiftCardToUser(company, userA ,giftCard2);
        companyService.distributeGiftCardToUser(company, userA ,giftCard3);

        // Then
        Assert.assertEquals(450, userService.calculateUserBalance(userA));
        Assert.assertEquals(550, company.getBalance());
    }

    @Test
    public void calculateUserBalanceForInvalideGiftCards() {
        // Given
        User userA = new User(new Account());
        Company company = new Company("Wedoogift", 500, new ArrayList<>(Arrays.asList(userA)));
        GiftCard giftCard1 = new GiftCard(LocalDate.now(), 100);
        GiftCard giftCard2 = new GiftCard(LocalDate.of(2020, Month.MARCH, 8), 200);
        GiftCard giftCard3 = new GiftCard(LocalDate.now(), 150);

        // When
        companyService.distributeGiftCardToUser(company, userA ,giftCard1);
        companyService.distributeGiftCardToUser(company, userA ,giftCard2);
        companyService.distributeGiftCardToUser(company, userA ,giftCard3);

        // Then
        Assert.assertEquals(250, userService.calculateUserBalance(userA));
        Assert.assertEquals(50, company.getBalance());
    }
}
