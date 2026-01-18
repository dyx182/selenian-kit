package com.github.dyx182.selenian_kit.element_state;

import com.codeborne.selenide.SelenideElement;
import com.github.dyx182.selenian_kit.element_state.dto.*;


public class ElementState {

    private ElementState() {
    }

    public static CheckboxStateDTO checkbox(SelenideElement element) {
        return CheckboxState.getState(element);
    }

    public static InputStateDTO input(SelenideElement element) {
        return InputState.getState(element);
    }

    public static ButtonStateDTO button(SelenideElement element) {
        return ButtonState.getState(element);
    }

    public static ImageStateDTO image(SelenideElement element) {
        return ImageState.getState(element);
    }

    public static LinkStateDTO link(SelenideElement element) {
        return LinkState.getState(element);
    }

    public static SelectStateDTO select(SelenideElement element) {
        return SelectState.getState(element);
    }
}
