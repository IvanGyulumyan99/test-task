package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class OpenBankPage {
    private final int MIN_DELAY = 5000;
    private final int MAX_DELAY = 20000;
    private ArrayList<Float> allRatesArraylist = new ArrayList<Float>();

    /**
     * Select internet-bank rates in drop-down box
     */
    public void openInternetBankRates() {
        $x("//span[contains(@class,'main-page-exchange__dropdown-title-highlight')]")
                .waitUntil(Condition.visible, MIN_DELAY)
                .click();
        $x("//div[contains(@class,'main-page-exchange__dropdown-overlay')]/ul/li[contains(@title,'интернет-банке')]")
                .waitUntil(Condition.visible, MIN_DELAY)
                .click();
    }

    /**
     * Get preferential and standard rates and parse them
     */
    public void getAllRates() {
        $x("//div[@id='rc-tabs-1-tab-preferentialRate']").waitUntil(Condition.visible, MAX_DELAY).click();
        List<String> tempList = $$(By.className("main-page-exchange__rate")).texts();
        $x("//div[@id='rc-tabs-1-tab-defaultRate']").waitUntil(Condition.visible, MAX_DELAY).click();
        tempList.addAll($$(By.className("main-page-exchange__rate")).texts());
        ArrayList<Float> parsedRatesList = new ArrayList<Float>();
        for (String s : tempList) {
            if (!s.isEmpty()) {
                parsedRatesList.add(Float.parseFloat(s.replace(',', '.')));
            }
        }
        allRatesArraylist.addAll(parsedRatesList);
    }


    public float getPreferentialUSDBuyCurrencyValue() {
        return allRatesArraylist.get(0);
    }

    public float getPreferentialUSDSellCurrencyValue() {
        return allRatesArraylist.get(1);
    }

    public float getPreferentialEURBuyCurrencyValue() {
        return allRatesArraylist.get(2);
    }

    public float getPreferentialEURSellCurrencyValue() {
        return allRatesArraylist.get(3);
    }

    public float getStandardUSDBuyCurrencyValue() {
        return allRatesArraylist.get(4);
    }

    public float getStandardUSDSellCurrencyValue() {
        return allRatesArraylist.get(5);
    }

    public float getStandardEURBuyCurrencyValue() {
        return allRatesArraylist.get(6);
    }

    public float getStandardEURSellCurrencyValue() {
        return allRatesArraylist.get(7);
    }

}
