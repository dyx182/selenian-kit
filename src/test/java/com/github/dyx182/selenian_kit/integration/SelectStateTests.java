package com.github.dyx182.selenian_kit.integration;

import com.codeborne.selenide.Selenide;
import com.github.dyx182.selenian_kit.element_state.ElementState;
import com.github.dyx182.selenian_kit.element_state.dto.SelectStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class SelectStateTests extends BaseIntegrationTests {

    private final String path = getClass().getResource("/pages/test-page.html").toString();

    @Test
    public void checkSelectAttributes() {
        Selenide.open(path);

        SelectStateDTO state = ElementState.select($("#singleSelect"));

        Assertions.assertAll(
                () -> Assertions.assertEquals("country", state.getName(), "name mismatch"),
                () -> Assertions.assertTrue(state.isDisplayed(), "isDisplayed should be true"),
                () -> Assertions.assertEquals("Select country dropdown", state.getAriaLabel(), "ariaLabel mismatch"),
                () -> Assertions.assertEquals("United Kingdom", state.getSelectedOption(), "selectedOption mismatch"),
                () -> Assertions.assertEquals("United States, United Kingdom, Germany, France",
                        String.join(", ", state.getOptions()), "options mismatch"),
                () -> Assertions.assertEquals("uk", state.getValue(), "value mismatch"),
                () -> Assertions.assertEquals("United Kingdom", state.getText(), "text should return selected option text"),
                () -> Assertions.assertEquals("singleSelect", state.getId(), "id mismatch"),
                () -> Assertions.assertNotNull(state.getColor(), "color should not be null"),
                () -> Assertions.assertNotNull(state.getBackgroundColor(), "backgroundColor should not be null"),
                () -> Assertions.assertNotNull(state.getBorderColor(), "borderColor should not be null"),
                () -> Assertions.assertTrue(state.getWidth() > 0, "width should be > 0"),
                () -> Assertions.assertTrue(state.getHeight() > 0, "height should be > 0"),
                () -> Assertions.assertTrue(state.getX() >= 0, "x should be >= 0"),
                () -> Assertions.assertTrue(state.getY() >= 0, "y should be >= 0"),
                () -> Assertions.assertEquals(1, state.getSelectedOptions().size(), "selectedOptions size should be 1"),
                () -> Assertions.assertEquals("United Kingdom", state.getSelectedOptions().get(0), "selectedOptions mismatch"),
                () -> Assertions.assertEquals("Single Select:", state.getLabelText(), "labelText mismatch")
        );
    }
}
