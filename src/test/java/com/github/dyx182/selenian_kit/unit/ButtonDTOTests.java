package com.github.dyx182.selenian_kit.unit;

import com.github.dyx182.state_kit.element_state.dto.ButtonStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ButtonDTOTests {

    @Test
    @Tag("unit")
    public void buildingButtonStateWithAllFields() {
        ButtonStateDTO dto = ButtonStateDTO.builder()
                .isDisplayed(true)
                .text("Submit")
                .id("submit-btn")
                .color("#ffffff")
                .backgroundColor("#007bff")
                .borderColor("#0069d9")
                .width(120)
                .height(40)
                .x(50)
                .y(100)
                .isEnabled(true)
                .type("submit")
                .name("submitForm")
                .value("Send")
                .ariaLabel("Submit registration form")
                .labelText("LabelText")
                .build();

        Assertions.assertTrue(dto.isDisplayed());
        Assertions.assertEquals("Submit", dto.getText());
        Assertions.assertEquals("submit-btn", dto.getId());
        Assertions.assertEquals("#ffffff", dto.getColor());
        Assertions.assertEquals("#007bff", dto.getBackgroundColor());
        Assertions.assertEquals("#0069d9", dto.getBorderColor());
        Assertions.assertEquals(120, dto.getWidth());
        Assertions.assertEquals(40, dto.getHeight());
        Assertions.assertEquals(50, dto.getX());
        Assertions.assertEquals(100, dto.getY());
        Assertions.assertTrue(dto.isEnabled());
        Assertions.assertEquals("submit", dto.getType());
        Assertions.assertEquals("submitForm", dto.getName());
        Assertions.assertEquals("Send", dto.getValue());
        Assertions.assertEquals("Submit registration form", dto.getAriaLabel());
        Assertions.assertEquals("LabelText", dto.getLabelText());
    }

    @Test
    public void buildingButtonStateWithMinimalFields() {
        ButtonStateDTO dto = ButtonStateDTO.builder()
                .isDisplayed(true)
                .text("test")
                .isEnabled(true)
                .build();

        Assertions.assertTrue(dto.isDisplayed());
        Assertions.assertEquals("test", dto.getText());
        Assertions.assertTrue(dto.isEnabled());
        Assertions.assertNull(dto.getType());
        Assertions.assertNull(dto.getName());
    }

    @Test
    public void equalsDTOsWithBaseField() {
        ButtonStateDTO dto1 = ButtonStateDTO.builder()
                .id("test-id")
                .build();

        ButtonStateDTO dto2 = ButtonStateDTO.builder()
                .id("test-id")
                .build();

        Assertions.assertEquals(dto1, dto2);
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void equalsDTOsWithButtonField() {
        ButtonStateDTO dto1 = ButtonStateDTO.builder()
                .name("submit")
                .type("submit")
                .isEnabled(true)
                .build();

        ButtonStateDTO dto2 = ButtonStateDTO.builder()
                .name("submit")
                .type("submit")
                .isEnabled(true)
                .build();

        Assertions.assertEquals(dto1, dto2);
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void equalsDTOsWithDifferentValuesShouldNotBeEqual() {
        ButtonStateDTO dto1 = ButtonStateDTO.builder()
                .id("btn-1")
                .isEnabled(true)
                .build();

        ButtonStateDTO dto2 = ButtonStateDTO.builder()
                .id("btn-2")
                .isEnabled(false)
                .build();

        Assertions.assertNotEquals(dto1, dto2);
    }
}
