package com.github.dyx182.selenian_kit.api;

import com.codeborne.selenide.SelenideElement;
import com.github.dyx182.selenian_kit.dto.CheckboxStateDTO;

public class CheckboxState implements ElementState{


    public static CheckboxStateDTO getCheckboxState(SelenideElement checkbox) {
        return CheckboxStateDTO.builder()
                .isSelected(checkbox.isSelected())
                .isEnabled(checkbox.isEnabled())
                .isDisplayed(checkbox.isDisplayed())
                .text(checkbox.getText())
                .id(checkbox.getAttribute("id"))
                .name(checkbox.getAttribute("name"))
                .ariaLabel(checkbox.getAttribute("aria-label"))
                .color(checkbox.getCssValue("color"))
                .backgroundColor(checkbox.getAttribute("background-color"))
                .borderColor(checkbox.getCssValue("border-color"))
                .checkmarkColor(checkbox.getAttribute("checkmark-color"))
                .wight(checkbox.getSize().width)
                .height(checkbox.getSize().height)
                .x(checkbox.getLocation().x)
                .y(checkbox.getLocation().y)
                .build();
    }
}
