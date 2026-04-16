package com.github.dyx182.selenian_kit.integration;

import com.codeborne.selenide.Selenide;
import com.github.dyx182.selenian_kit.element_state.ElementState;
import com.github.dyx182.selenian_kit.element_state.dto.InputStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class InputStateTests extends BaseIntegrationTests {

    private final String path = getClass().getResource("/pages/test-page.html").toString();

    @Test
    public void getAttributeElement() {
        Selenide.open(path);

        InputStateDTO inputState = ElementState.input($x("//input[@id='textInput']"));

        Assertions.assertAll(
                () -> Assertions.assertTrue(inputState.isEnabled()),
                () -> Assertions.assertTrue(inputState.isDisplayed()),
                () -> Assertions.assertEquals("username", inputState.getName()),
                () -> Assertions.assertEquals("Enter username", inputState.getPlaceholder()),
                () -> Assertions.assertEquals("text", inputState.getType()),
                () -> Assertions.assertEquals("testuser", inputState.getValue())
        );
    }

    @Test
    public void getLabelInputAttribute() {
        Selenide.open(path);

        InputStateDTO inputState = ElementState.input($x("//label[@for='textInput']"));

        Assertions.assertEquals("Text Input:", inputState.getText());
    }

    @Test
    public void getAttributeDisabledInput() {
        Selenide.open(path);

        InputStateDTO inputState = ElementState.input($x("//input[@id='disabledInput']"));

        Assertions.assertFalse(inputState.isEnabled());
    }
    //todo add test to position on page
}
