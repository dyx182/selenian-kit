package com.github.dyx182.state_kit.element_state;

import com.codeborne.selenide.SelenideElement;
import com.github.dyx182.state_kit.element_state.dto.BaseElementStateDTO;

import static com.github.dyx182.state_kit.element_state.utils.LabelUtils.getLabelText;

class BaseState {

    static BaseElementStateDTO getState(SelenideElement element) {
        return BaseElementStateDTO.builder()
                .isDisplayed(element.isDisplayed())
                .text(element.getText())
                .id(element.getAttribute("id"))
                .color(element.getCssValue("color"))
                .backgroundColor(element.getCssValue("background-color"))
                .borderColor(element.getCssValue("border-color"))
                .width(element.getSize().width)
                .height(element.getSize().height)
                .x(element.getLocation().x)
                .y(element.getLocation().y)
                .labelText(getLabelText(element))
                .build();
    }
}
