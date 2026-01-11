package com.github.dyx182.selenian_kit;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.github.dyx182.selenian_kit.dto.CheckboxStateDTO;

class CheckboxState {

    static CheckboxStateDTO getState(SelenideElement checkbox) {
        return CheckboxStateDTO.builder()
                .isSelected(checkbox.isSelected())
                .isEnabled(checkbox.isEnabled())
                .isDisplayed(checkbox.isDisplayed())
                .text(checkbox.getText())
                .id(checkbox.getAttribute("id"))
                .name(checkbox.getAttribute("name"))
                .ariaLabel(checkbox.getAttribute("aria-label"))
                .color(checkbox.getCssValue("color"))
                .backgroundColor(checkbox.getCssValue("background-color"))
                .borderColor(checkbox.getCssValue("border-color"))
                .width(checkbox.getSize().width)
                .height(checkbox.getSize().height)
                .x(checkbox.getLocation().x)
                .y(checkbox.getLocation().y)
                .labelText(getLabelText(checkbox))
                .build();
    }

    private static String getLabelText(SelenideElement checkbox) {
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
