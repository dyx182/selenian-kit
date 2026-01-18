package com.github.dyx182.selenian_kit.element_state;

import com.codeborne.selenide.SelenideElement;
import com.github.dyx182.selenian_kit.element_state.dto.LinkStateDTO;

class LinkState {

    static LinkStateDTO getState(SelenideElement link) {
        return LinkStateDTO.builder()
                .isDisplayed(link.isDisplayed())
                .text(link.getText())
                .id(link.getAttribute("id"))
                .color(link.getCssValue("color"))
                .backgroundColor(link.getCssValue("background-color"))
                .borderColor(link.getCssValue("border-color"))
                .width(link.getSize().width)
                .height(link.getSize().height)
                .x(link.getLocation().x)
                .y(link.getLocation().y)
                .build();
    }
}
