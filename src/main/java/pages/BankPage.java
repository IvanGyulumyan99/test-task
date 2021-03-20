package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BankPage {

    public float getUSDBuyCurrencyValue() {
        String USDBuyCurrency = $(By.xpath("//tr[2]//td[2]//span")).getText().replace(',', '.');
        return Float.parseFloat(USDBuyCurrency);
    }

    public float getUSDSellCurrencyValue() {
        String USDSellCurrency = $(By.xpath("//tr[2]//td[4]//span")).getText().replace(',', '.');
        return Float.parseFloat(USDSellCurrency);
    }

    public float getEURBuyCurrencyValue() {
        String EURBuyCurrency = $(By.xpath("//tr[3]//td[2]//span")).getText().replace(',', '.');
        return Float.parseFloat(EURBuyCurrency);
    }

    public float getEURSellCurrencyValue() {
        String EURSellCurrency = $(By.xpath("//tr[3]//td[4]//span")).getText().replace(',', '.');
        return Float.parseFloat(EURSellCurrency);
    }

}
