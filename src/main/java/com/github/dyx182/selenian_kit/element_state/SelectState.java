package com.github.dyx182.selenian_kit.element_state;

import com.codeborne.selenide.SelenideElement;
import com.github.dyx182.selenian_kit.element_state.dto.SelectStateDTO;

import java.util.List;

class SelectState {

    static SelectStateDTO getState(SelenideElement select) {
        return SelectStateDTO.builder()
                .isDisplayed(select.isDisplayed())
                .text(select.getText())
                .id(select.getAttribute("id"))
                .color(select.getCssValue("color"))
                .backgroundColor(select.getCssValue("background-color"))
                .borderColor(select.getCssValue("border-color"))
                .width(select.getSize().width)
                .height(select.getSize().height)
                .x(select.getLocation().x)
                .y(select.getLocation().y)
                .name(select.getAttribute("name"))
                .value(select.getValue())
                .ariaLabel(select.getAttribute("aria-label"))
                .options(select.getOptions().texts())
                .selectedOption(select.getSelectedOptionText())
                .selectedOptions(select.getSelectedOptions().texts())
                .build();
    }
}
