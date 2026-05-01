package com.github.dyx182.state_kit.integration;

import com.codeborne.selenide.Selenide;
import com.github.dyx182.state_kit.element_state.ElementState;
import com.github.dyx182.state_kit.element_state.dto.ButtonStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class ButtonIntegrationTests extends BaseIntegrationTests {

    private final String path = getClass().getResource("/pages/test-page.html").toString();

    @Test
    public void checkAttributeButtonElement() {
        Selenide.open(path);

        ButtonStateDTO buttonState = ElementState.button($x("//button[@name='register']"));

        Assertions.assertAll(
                () -> Assertions.assertTrue(buttonState.isEnabled(), "is not enabled"),
                () -> Assertions.assertEquals("submit", buttonState.getType(), "type mismatch"),
                () -> Assertions.assertEquals("register", buttonState.getName(), "name mismatch"),
                () -> Assertions.assertEquals("send", buttonState.getValue(), "value mismatch"),
                () -> Assertions.assertEquals("Submit registration form", buttonState.getAriaLabel(), "arialabel mismatch"),
                () -> Assertions.assertEquals("Register", buttonState.getText(), "element text mismatch"),
                () -> Assertions.assertEquals("Submit Button (inside form):", buttonState.getLabelText(), "label text mismatch"),
                () -> Assertions.assertTrue(buttonState.isDisplayed(), "isDisplayed should be true"),
                () -> Assertions.assertEquals("registerBtn", buttonState.getId(), "id mismatch"),
                () -> Assertions.assertNotNull(buttonState.getColor(), "color should not be null"),
                () -> Assertions.assertNotNull(buttonState.getBackgroundColor(), "backgroundColor should not be null"),
                () -> Assertions.assertNotNull(buttonState.getBorderColor(), "borderColor should not be null"),
                () -> Assertions.assertTrue(buttonState.getWidth() > 0, "width should be > 0"),
                () -> Assertions.assertTrue(buttonState.getHeight() > 0, "height should be > 0"),
                () -> Assertions.assertTrue(buttonState.getX() >= 0, "x should be >= 0"),
                () -> Assertions.assertTrue(buttonState.getY() >= 0, "y should be >= 0")
        );
    }
}
