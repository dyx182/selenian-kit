package com.github.dyx182.selenian_kit.integration;

import com.codeborne.selenide.Selenide;
import com.github.dyx182.state_kit.element_state.ElementState;
import com.github.dyx182.state_kit.element_state.dto.InputStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class InputStateTests extends BaseIntegrationTests {

    private final String path = getClass().getResource("/pages/test-page.html").toString();

    @Test
    public void checkAttributeElement() {
        Selenide.open(path);

        InputStateDTO inputState = ElementState.input($x("//input[@id='textInput']"));

        Assertions.assertAll(
                () -> Assertions.assertTrue(inputState.isEnabled(), "isEnabled should be true"),
                () -> Assertions.assertTrue(inputState.isDisplayed(), "isDisplayed should be true"),
                () -> Assertions.assertEquals("username", inputState.getName(), "name mismatch"),
                () -> Assertions.assertEquals("Enter username", inputState.getPlaceholder(), "placeholder mismatch"),
                () -> Assertions.assertEquals("text", inputState.getType(), "type mismatch"),
                () -> Assertions.assertEquals("testuser", inputState.getValue(), "value mismatch"),
                () -> Assertions.assertEquals("textInput", inputState.getId(), "id mismatch"),
                () -> Assertions.assertNotNull(inputState.getColor(), "color should not be null"),
                () -> Assertions.assertNotNull(inputState.getBackgroundColor(), "backgroundColor should not be null"),
                () -> Assertions.assertNotNull(inputState.getBorderColor(), "borderColor should not be null"),
                () -> Assertions.assertTrue(inputState.getWidth() > 0, "width should be > 0"),
                () -> Assertions.assertTrue(inputState.getHeight() > 0, "height should be > 0"),
                () -> Assertions.assertTrue(inputState.getX() >= 0, "x should be >= 0"),
                () -> Assertions.assertTrue(inputState.getY() >= 0, "y should be >= 0"),
                () -> Assertions.assertNull(inputState.getAriaLabel(), "ariaLabel should be null for this input"),
                () -> Assertions.assertEquals("Text Input:", inputState.getLabelText(), "labelText mismatch")
        );
    }

    @Test
    public void checkLabelInputAttribute() {
        Selenide.open(path);

        InputStateDTO inputState = ElementState.input($x("//input[@id='textInput']"));

        Assertions.assertEquals("Text Input:", inputState.getLabelText(), "labelText mismatch");
    }
}
