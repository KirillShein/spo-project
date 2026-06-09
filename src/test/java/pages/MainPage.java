package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private ElementsCollection sectionName = $$(".MuiListItemText-root");

    public MainPage checkSectionsPresence(String value) {
        sectionName.findBy(text(value));

        return this;
    }
}
