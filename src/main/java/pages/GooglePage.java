package pages;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.*;

public class GooglePage {
    /**
     * Enters search term to the search field
     * @param searchTerm the term we want to enter
     */
    public void enterSearchTerm(String searchTerm) {
        $x("//input[@name='q']").setValue(searchTerm);
    }

    public void clickSearchButton() {
        $x("//*[@name = 'btnK']").click();
    }

    /**
     * Indicates that at least one link is found
     * @param searchLink the link we want to search on page
     * @return true if at least one link found
     */
    public boolean isSearchLinksFound(String searchLink) {
        return $$(By.tagName("a"))
                .filterBy(Condition.attribute("href", searchLink)).size() > 0;
    }

    /**
     * Opens the first of our found links
     */
    public void openBankPage() {
        $$(By.tagName("a"))
                .filterBy(Condition.attribute("href", "https://www.open.ru/")).first().click();
    }

}
