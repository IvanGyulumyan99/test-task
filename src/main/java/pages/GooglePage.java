package pages;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.*;

public class GooglePage {
    public void enterSearchQuery(String searchQuery) {
        $x("//input[@name='q']").setValue(searchQuery);
    }

    public void clickSearchButton() {
        $x("//*[@name = 'btnK']").click();
    }

    public boolean isSearchLinksFound(String searchLink) {
        return $$(By.tagName("a"))
                .filterBy(Condition.attribute("href", searchLink)).size() > 0;
    }

    public void openBankPage() {
        $$(By.tagName("a"))
                .filterBy(Condition.attribute("href", "https://www.open.ru/")).first().click();
    }

}
