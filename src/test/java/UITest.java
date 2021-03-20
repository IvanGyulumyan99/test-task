import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BankPage;
import pages.GooglePage;

import static com.codeborne.selenide.Selenide.*;


public class UITest {
    String googleUrl = "http://google.com";
    String searchQuery = "Открытие";
    String bankLink = "https://www.open.ru/";

    @Test(description = "Проверка курса обмена валют в банке Открытие")
    public void openBankTest() {
        open(googleUrl);
        BankPage bankPage = new BankPage();
        GooglePage googlePage = new GooglePage();
        googlePage.enterSearchQuery(searchQuery);
        googlePage.clickSearchButton();
        Assert.assertTrue(googlePage.isSearchLinksFound(bankLink));
        googlePage.openBankPage();
        bankPage.openInternetBankRates();
        Assert.assertTrue(bankPage.getUSDBuyCurrencyValue() < bankPage.getUSDSellCurrencyValue());
        Assert.assertTrue(bankPage.getEURBuyCurrencyValue() < bankPage.getEURSellCurrencyValue());
    }
}
