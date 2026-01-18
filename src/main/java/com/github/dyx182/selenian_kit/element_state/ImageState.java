package com.github.dyx182.selenian_kit.element_state;

import com.codeborne.selenide.SelenideElement;
import com.github.dyx182.selenian_kit.element_state.dto.ImageStateDTO;

import java.util.List;

class ImageState {

    static ImageStateDTO getState(SelenideElement image) {
        return ImageStateDTO.builder()
                .isDisplayed(image.isDisplayed())
                .text(image.getText())
                .id(image.getAttribute("id"))
                .color(image.getCssValue("color"))
                .backgroundColor(image.getCssValue("background-color"))
                .borderColor(image.getCssValue("border-color"))
                .width(image.getSize().width)
                .height(image.getSize().height)
                .x(image.getLocation().x)
                .y(image.getLocation().y)
                .src(image.getAttribute("src"))
                .alt(image.getAttribute("alt"))
                .title(image.getAttribute("title"))
                .ariaLabel(image.getAttribute("aria-label"))
                .build();
    }
}
