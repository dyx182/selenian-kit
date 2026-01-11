package com.github.dyx182.selenian_kit.api;

import com.codeborne.selenide.SelenideElement;
import com.github.dyx182.selenian_kit.dto.CheckboxStateDTO;

import static com.github.dyx182.selenian_kit.dto.CheckboxStateDTO.getLabelText;

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
                .backgroundColor(checkbox.getCssValue("background-color"))
                .borderColor(checkbox.getCssValue("border-color"))
                .width(checkbox.getSize().width)
                .height(checkbox.getSize().height)
                .x(checkbox.getLocation().x)
                .y(checkbox.getLocation().y)
                .labelText(getLabelText(checkbox))
                .build();
    }

    public static CheckboxStateDTO getCheckboxState(SelenideElement checkbox, String value) {
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
                .attribute(checkbox.getAttribute(value))
                .cssValue(checkbox.getCssValue(value))
                .labelText(getLabelText(checkbox))
                .build();
    }
}
