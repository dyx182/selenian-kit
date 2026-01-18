package com.github.dyx182.selenian_kit.element_state;

import com.codeborne.selenide.SelenideElement;
import com.github.dyx182.selenian_kit.element_state.dto.InputStateDTO;

class InputState {

    static InputStateDTO getState(SelenideElement textInput) {
        return InputStateDTO.builder()
                .isDisplayed(textInput.isDisplayed())
                .text(textInput.getText())
                .id(textInput.getAttribute("id"))
                .color(textInput.getCssValue("color"))
                .backgroundColor(textInput.getCssValue("background-color"))
                .borderColor(textInput.getCssValue("border-color"))
                .width(textInput.getSize().width)
                .height(textInput.getSize().height)
                .x(textInput.getLocation().x)
                .y(textInput.getLocation().y)
                .isEnabled(textInput.isEnabled())
                .name(textInput.getAttribute("name"))
                .value(textInput.getValue())
                .placeholder(textInput.getAttribute("placeholder"))
                .type(textInput.getAttribute("type"))
                .ariaLabel(textInput.getAttribute("aria-label"))
                .build();
    }

}
