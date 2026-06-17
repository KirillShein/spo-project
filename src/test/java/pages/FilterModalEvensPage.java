package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import utils.TestData;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class FilterModalEvensPage {

    private SelenideElement inputEventsForDate = $x("//label[text()='События за']/following-sibling::div//input"),
                            inputTypeEvent = $("#checkboxes-tags-demo");

    private ElementsCollection checkboxes = $$(".MuiAutocomplete-option");

    private String selectedOneCheckbox;
    private List<String> selectedMultipleCheckboxes = new ArrayList<>();

    public FilterModalEvensPage clickInputEventsForDate() {
        inputEventsForDate.click();

        return this;
    }

    public FilterModalEvensPage clickInputTypeEvent() {
        inputTypeEvent.click();

        return this;
    }

    public FilterModalEvensPage selectRandomSingleCheckbox() {

        List<SelenideElement> availableOptions = new ArrayList<>();
        for (SelenideElement checkbox : checkboxes) {
            if (checkbox.isDisplayed() && checkbox.isEnabled()) {
                availableOptions.add(checkbox);
            }
        }

        if (availableOptions.isEmpty()) {
            throw new RuntimeException("Нет доступных опций для выбора");
        }

        Random random = new Random();
        SelenideElement selectedOption = availableOptions.get(random.nextInt(availableOptions.size()));

        selectedOneCheckbox = selectedOption.getText();

        selectedOption.click();

        return this;
    }

    public FilterModalEvensPage selectRandomMultipleCheckboxes(int count) {
        // Получаем все доступные опции
        List<SelenideElement> availableOptions = new ArrayList<>();
        for (SelenideElement checkbox : checkboxes) {
            if (checkbox.isDisplayed() && checkbox.isEnabled()) {
                availableOptions.add(checkbox);
            }
        }

        if (availableOptions.isEmpty()) {
            throw new RuntimeException("Нет доступных опций для выбора");
        }

        int selectCount = Math.min(count, availableOptions.size());

        // Перемешиваем список и выбираем первые `selectCount` элементов
        Random random = new Random();
        java.util.Collections.shuffle(availableOptions, random);

        List<SelenideElement> selectedOptions = availableOptions.subList(0, selectCount);

        selectedMultipleCheckboxes.clear();
        for (SelenideElement option : selectedOptions) {
            String text = option.getText();
            selectedMultipleCheckboxes.add(text);
            System.out.println("Выбрана опция: " + text);
            option.click();
        }


        return this;
    }

    public String getSelectedOneTypeEvent() {
        return selectedOneCheckbox;
    }

    public List<String> getSelectedMultipleCheckboxes() {
        return selectedMultipleCheckboxes;
    }

}
