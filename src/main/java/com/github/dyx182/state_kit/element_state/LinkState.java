package com.github.dyx182.state_kit.element_state;

import com.codeborne.selenide.SelenideElement;
import com.github.dyx182.state_kit.element_state.dto.LinkStateDTO;

import static com.github.dyx182.state_kit.element_state.utils.LabelUtils.getLabelText;

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
                .isEnabled(link.isEnabled())
                .labelText(getLabelText(link))
                .href(link.getAttribute("href"))
                .target(link.getAttribute("target"))
                .ariaLabel(link.getAttribute("aria-label"))
                .title(link.getAttribute("title"))
                .build();
    }

    public static class ListState {
    }
}
