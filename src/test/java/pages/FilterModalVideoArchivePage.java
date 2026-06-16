package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FilterModalVideoArchivePage {

    private SelenideElement inputNameFilter = $("#archiveUserName"),
                            buttonSearch = $x("//button[text()='Поиск']"),
                            inputCodeEmployyeFilter = $("#archiveCode"),
                            inputCameraFilter = $("#arhiveCameraId"),
                            inputDepartmentFilter = $("#archiveDepartment"),
                            startDateFilter = $x("//label[text()='Дата c']/following-sibling::div//input");



    public FilterModalVideoArchivePage inputName(String value) {
        inputNameFilter.setValue(value);

        return this;
    }

    public  FilterModalVideoArchivePage clickButtonSearch() {
        buttonSearch.click();

        return this;
    }

    public FilterModalVideoArchivePage inputCodeEmployee(String value) {
        inputCodeEmployyeFilter.setValue(value);

        return this;
    }

    public FilterModalVideoArchivePage inputCamera(String value) {
        inputCameraFilter.setValue(value);

        return this;
    }


    public FilterModalVideoArchivePage inputDepartment(String value) {
        inputDepartmentFilter.setValue(value);

        return this;
    }

    public FilterModalVideoArchivePage startDateClick() {
        startDateFilter.click();

        return this;
    }
}
