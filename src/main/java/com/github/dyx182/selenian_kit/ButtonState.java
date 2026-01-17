package com.github.dyx182.selenian_kit;

import com.codeborne.selenide.SelenideElement;
import com.github.dyx182.selenian_kit.dto.ButtonStateDTO;

public class ButtonState {

    static ButtonStateDTO buttonState(SelenideElement button) {
        return ButtonStateDTO.builder()
                .isDisplayed(button.isDisplayed())
                .text(button.getText())
                .id(button.getAttribute("id"))
                .color(button.getCssValue("color"))
                .backgroundColor(button.getCssValue("background-color"))
                .borderColor(button.getCssValue("border-color"))
                .width(button.getSize().width)
                .height(button.getSize().height)
                .x(button.getLocation().x)
                .y(button.getLocation().y)
                .isEnabled(button.isEnabled())
                .type(button.getAttribute("type"))
                .name(button.getAttribute("name"))
                .value(button.getValue())
                .ariaLabel(button.getAttribute("aria-label"))
                .ariaLabel(button.getAttribute("form"))
                .build();
    }
}
