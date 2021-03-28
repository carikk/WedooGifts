import Entities.Account;
import Entities.Company;
import Entities.GiftCard;
import Entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class CompanyTest {


    @Test
    public void successfullDistribution() {
        // Given
        User userA = new User(new Account());
        Company company = new Company("Wedoogift",1000, new ArrayList<>(Arrays.asList(userA)));
        GiftCard giftCard = new GiftCard(LocalDate.now(), 100);
        String returnMessage;

        // When
        returnMessage = company.distributeGiftCardToUser(userA ,giftCard);

        // Then
        Assert.assertEquals("Successfully distributed !", returnMessage);
        Assert.assertEquals(900, company.getBalance());
        Assert.assertEquals(100, userA.calculateUserBalance());
    }

    @Test
    public void companyBalanceDoesntAllowDistribution() {
        // Given
        User userA = new User(new Account());
        Company company = new Company("Wedoogift", 50, new ArrayList<>(Arrays.asList(userA)));
        GiftCard giftCard = new GiftCard(LocalDate.now(), 100);
        String returnMessage;

        // When
        returnMessage = company.distributeGiftCardToUser(userA ,giftCard);

        // Then
        Assert.assertEquals("The company cannot afford That !", returnMessage);
        Assert.assertEquals(50, company.getBalance());
        Assert.assertEquals(0, userA.calculateUserBalance());
    }

    @Test
    public void calculateUserBalanceForValideTickets() {
        // Given
        User userA = new User(new Account());
        Company company = new Company("Wedoogift", 1000, new ArrayList<>(Arrays.asList(userA)));
        GiftCard giftCard1 = new GiftCard(LocalDate.now(), 100);
        GiftCard giftCard2 = new GiftCard(LocalDate.now(), 200);
        GiftCard giftCard3 = new GiftCard(LocalDate.now(), 150);
        String returnMessage;

        // When
        company.distributeGiftCardToUser(userA ,giftCard1);
        company.distributeGiftCardToUser(userA ,giftCard2);
        company.distributeGiftCardToUser(userA ,giftCard3);

        // Then
        Assert.assertEquals(450, userA.calculateUserBalance());
        Assert.assertEquals(550, company.getBalance());

    }

    @Test
    public void calculateUserBalanceForInvalideTickets() {
        // Given
        User userA = new User(new Account());
        Company company = new Company("Wedoogift", 500, new ArrayList<>(Arrays.asList(userA)));
        GiftCard giftCard1 = new GiftCard(LocalDate.now(), 100);
        GiftCard giftCard2 = new GiftCard(LocalDate.of(2020, Month.MARCH, 8), 200);
        GiftCard giftCard3 = new GiftCard(LocalDate.now(), 150);
        String returnMessage;

        // When
        company.distributeGiftCardToUser(userA ,giftCard1);
        company.distributeGiftCardToUser(userA ,giftCard2);
        company.distributeGiftCardToUser(userA ,giftCard3);

        // Then
        Assert.assertEquals(250, userA.calculateUserBalance());
        Assert.assertEquals(50, company.getBalance());

    }
}
