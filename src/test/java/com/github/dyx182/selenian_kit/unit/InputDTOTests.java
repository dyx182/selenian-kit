package com.github.dyx182.selenian_kit.unit;

import com.github.dyx182.selenian_kit.element_state.dto.InputStateDTO;
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
                .build();

        Assertions.assertTrue(dto.isDisplayed(), "isDisplayed should be true");
        Assertions.assertEquals("sample text", dto.getText(), "text mismatch");
        Assertions.assertEquals("input-123", dto.getId(), "id mismatch");
        Assertions.assertEquals("#333333", dto.getColor(), "color mismatch");
        Assertions.assertEquals("#ffffff", dto.getBackgroundColor(), "backgroundColor mismatch");
        Assertions.assertEquals("#cccccc", dto.getBorderColor(), "borderColor mismatch");
        Assertions.assertEquals(200, dto.getWidth(), "width mismatch");
        Assertions.assertEquals(30, dto.getHeight(), "height mismatch");
        Assertions.assertEquals(100, dto.getX(), "x coordinate mismatch");
        Assertions.assertEquals(50, dto.getY(), "y coordinate mismatch");
        Assertions.assertTrue(dto.isEnabled(), "isEnabled should be true");
        Assertions.assertEquals("username", dto.getName(), "name mismatch");
        Assertions.assertEquals("testuser", dto.getValue(), "value mismatch");
        Assertions.assertEquals("Enter username", dto.getPlaceholder(), "placeholder mismatch");
        Assertions.assertEquals("text", dto.getType(), "type mismatch");
        Assertions.assertEquals("Username input field", dto.getAriaLabel(), "ariaLabel mismatch");
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
