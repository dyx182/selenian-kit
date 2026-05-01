package com.github.dyx182.state_kit.element_state;

import com.codeborne.selenide.SelenideElement;
import com.github.dyx182.state_kit.element_state.dto.CheckboxStateDTO;

import static com.github.dyx182.state_kit.element_state.utils.LabelUtils.getLabelText;

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
}
