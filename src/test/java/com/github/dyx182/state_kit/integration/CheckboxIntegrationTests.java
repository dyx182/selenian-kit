package com.github.dyx182.state_kit.integration;

import com.codeborne.selenide.Selenide;
import com.github.dyx182.state_kit.element_state.ElementState;
import com.github.dyx182.state_kit.element_state.dto.CheckboxStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class CheckboxIntegrationTests extends BaseIntegrationTests{

    private final String path = getClass().getResource("/pages/test-page.html").toString();

    @Test
    public void checkCheckboxAttribute() {
        Selenide.open(path);

        CheckboxStateDTO checkboxState = ElementState.checkbox($x("//input[@name='precedingLabel']"));

        Assertions.assertAll(
                () -> Assertions.assertFalse(checkboxState.isSelected(), "isSelected should be false"),
                () -> Assertions.assertFalse(checkboxState.isChecked(), "isChecked should be false"),
                () -> Assertions.assertTrue(checkboxState.isEnabled(), "isEnabled should be true"),
                () -> Assertions.assertEquals("precedingLabel", checkboxState.getName(), "name mismatch"),
                () -> Assertions.assertEquals("with aria-label", checkboxState.getAriaLabel(), "ariaLabel mismatch"),
                () -> Assertions.assertTrue(checkboxState.isDisplayed(), "isDisplayed should be true"),
                () -> Assertions.assertEquals("", checkboxState.getText(), "text should be empty"),
                () -> Assertions.assertEquals("checkboxPrecedingLabel", checkboxState.getId(), "id mismatch"),
                () -> Assertions.assertNotNull(checkboxState.getColor(), "color should not be null"),
                () -> Assertions.assertNotNull(checkboxState.getBackgroundColor(), "backgroundColor should not be null"),
                () -> Assertions.assertNotNull(checkboxState.getBorderColor(), "borderColor should not be null"),
                () -> Assertions.assertTrue(checkboxState.getWidth() > 0, "width should be > 0"),
                () -> Assertions.assertTrue(checkboxState.getHeight() > 0, "height should be > 0"),
                () -> Assertions.assertTrue(checkboxState.getX() >= 0, "x should be >= 0"),
                () -> Assertions.assertTrue(checkboxState.getY() >= 0, "y should be >= 0")
        );
    }

    @Test
    public void checkPrecedingLabelText() {
        Selenide.open(path);

        CheckboxStateDTO checkboxState = ElementState.checkbox($x("//input[@name='precedingLabel']"));

        Assertions.assertEquals("Preceding sibling label:", checkboxState.getLabelText());
    }

    @Test
    public void checkWrappedLabelText() {
        Selenide.open(path);

        CheckboxStateDTO checkboxState = ElementState.checkbox($x("//input[@name='wrapped']"));

        Assertions.assertEquals("Wrapping label text", checkboxState.getLabelText());
    }

    @Test
    public void checkFollowingSpanText() {
        Selenide.open(path);

        CheckboxStateDTO checkboxState = ElementState.checkbox($x("//input[@name='followingSpan']"));

        Assertions.assertEquals("Following sibling span text", checkboxState.getLabelText());
    }

    @Test
    public void checkPrecedingSpanText() {
        Selenide.open(path);

        CheckboxStateDTO checkboxState = ElementState.checkbox($x("//input[@name='precedingSpan']"));

        Assertions.assertEquals("Preceding sibling span text", checkboxState.getLabelText());
    }
}
