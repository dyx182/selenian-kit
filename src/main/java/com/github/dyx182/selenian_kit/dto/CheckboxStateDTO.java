package com.github.dyx182.selenian_kit.dto;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CheckboxStateDTO {

    boolean isSelected;
    boolean isEnabled;
    boolean isDisplayed;

    String text;
    String labelText;
    String id;
    String name;
    String ariaLabel;
    String color;
    String backgroundColor;
    String borderColor;
    String attribute;
    String cssValue;

    int width;
    int height;
    int x;
    int y;

    public boolean isChecked() {
        return isSelected;
    }

    public static String getLabelText(SelenideElement checkbox) {
        String id = checkbox.getAttribute("id");
        if (id != null) {
            try {
                return Selenide.$("label[for='" + id + "']").getText();
            } catch (ElementNotFound e) {
            }
        }
        return "";
    }
}
