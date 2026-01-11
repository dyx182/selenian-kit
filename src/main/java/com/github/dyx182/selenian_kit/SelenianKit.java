package com.github.dyx182.selenian_kit;

import com.codeborne.selenide.SelenideElement;
import com.github.dyx182.selenian_kit.dto.CheckboxStateDTO;
import com.github.dyx182.selenian_kit.dto.InputStateDTO;


public class SelenianKit {

    private SelenianKit() {}

    public static CheckboxStateDTO getCheckboxState(SelenideElement element) {
        return CheckboxState.getState(element);
    }

    public static InputStateDTO getInputState(SelenideElement element) {
        return InputState.getState(element);
    }
}
