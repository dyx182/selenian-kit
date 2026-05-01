package com.github.dyx182.state_kit.unit;

import com.github.dyx182.state_kit.element_state.dto.InputStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputDTOTests {

    //todo add negative tests
    @Test
    public void buildingInputStateWithAllFields() {
        InputStateDTO dto = InputStateDTO.builder()
                .isDisplayed(true)
                .text("sample text")
                .id("input-123")
                .color("#333333")
                .backgroundColor("#ffffff")
                .borderColor("#cccccc")
                .width(200)
                .height(30)
                .x(100)
                .y(50)
                .isEnabled(true)
                .name("username")
                .value("testuser")
                .placeholder("Enter username")
                .type("text")
                .ariaLabel("Username input field")
                .labelText("LabelText")
                .build();

        Assertions.assertTrue(dto.isDisplayed());
        Assertions.assertEquals("sample text", dto.getText());
        Assertions.assertEquals("input-123", dto.getId());
        Assertions.assertEquals("#333333", dto.getColor());
        Assertions.assertEquals("#ffffff", dto.getBackgroundColor());
        Assertions.assertEquals("#cccccc", dto.getBorderColor());
        Assertions.assertEquals(200, dto.getWidth());
        Assertions.assertEquals(30, dto.getHeight());
        Assertions.assertEquals(100, dto.getX());
        Assertions.assertEquals(50, dto.getY());
        Assertions.assertTrue(dto.isEnabled());
        Assertions.assertEquals("username", dto.getName());
        Assertions.assertEquals("testuser", dto.getValue());
        Assertions.assertEquals("Enter username", dto.getPlaceholder());
        Assertions.assertEquals("text", dto.getType());
        Assertions.assertEquals("Username input field", dto.getAriaLabel());
        Assertions.assertEquals("LabelText", dto.getLabelText());
    }

    @Test
    public void equalsDTOsWithBaseField() {
        InputStateDTO dto1 = InputStateDTO.builder()
                .id("test")
                .build();

        InputStateDTO dto2 = InputStateDTO.builder()
                .id("test")
                .build();

        Assertions.assertEquals(dto1, dto2);
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void equalsDTOsWithInputField() {
        InputStateDTO dto1 = InputStateDTO.builder()
                .name("test_name")
                .build();

        InputStateDTO dto2 = InputStateDTO.builder()
                .name("test_name")
                .build();

        Assertions.assertEquals(dto1, dto2);
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());
    }
}
