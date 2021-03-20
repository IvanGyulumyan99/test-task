package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class OpenBankPage {

    public void openInternetBankRates() {
        $x("//span[contains(@class,'main-page-exchange__dropdown-title-highlight')]")
                .waitUntil(Condition.visible, 5000)
                .click();
        $x("//div[contains(@class,'main-page-exchange__dropdown-overlay')]/ul/li[contains(@title,'интернет-банке')]")
                .waitUntil(Condition.visible, 5000)
                .click();
    }

    public float getUSDBuyCurrencyValue() {
        String USDBuyCurrency = $x("//tr[2]//td[2]//span").getText().replace(',', '.');
        return Float.parseFloat(USDBuyCurrency);
    }

    public float getUSDSellCurrencyValue() {
        String USDSellCurrency = $x("//tr[2]//td[4]//span").getText().replace(',', '.');
        return Float.parseFloat(USDSellCurrency);
    }

    public float getEURBuyCurrencyValue() {
        String EURBuyCurrency = $x("//tr[3]//td[2]//span").getText().replace(',', '.');
        return Float.parseFloat(EURBuyCurrency);
    }

    public float getEURSellCurrencyValue() {
        String EURSellCurrency = $x("//tr[3]//td[4]//span").getText().replace(',', '.');
        return Float.parseFloat(EURSellCurrency);
    }

}
