import org.testng.annotations.Test;
import pages.GooglePage;
import pages.OpenBankPage;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;


public class OpenBankUITest {

    private final static String GOOGLE_URL = "http://google.com";
    private final static String SEARCH_TERM = "Открытие";
    private final static String BANK_URL = "https://www.open.ru/";

    @Test(description = "Проверка курса обмена валют в банке Открытие")
    public void openBankTest() {
        open(GOOGLE_URL);
        GooglePage googlePage = new GooglePage();
        googlePage.enterSearchTerm(SEARCH_TERM);
        googlePage.clickSearchButton();
        assertTrue(googlePage.isSearchLinksFound(BANK_URL));
        googlePage.openBankPage();
        OpenBankPage bankPage = new OpenBankPage();
        bankPage.openInternetBankRates();
        assertTrue(bankPage.getUSDBuyCurrencyValue() < bankPage.getUSDSellCurrencyValue());
        assertTrue(bankPage.getEURBuyCurrencyValue() < bankPage.getEURSellCurrencyValue());
    }
}
