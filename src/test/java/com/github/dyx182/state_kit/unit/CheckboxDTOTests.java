package com.github.dyx182.state_kit.unit;

import com.github.dyx182.state_kit.element_state.dto.CheckboxStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckboxDTOTests {

    @Test
    public void isCheckedEqualsIsSelected() {
        CheckboxStateDTO dto = CheckboxStateDTO.builder()
                .isSelected(true)
                .build();

        Assertions.assertEquals(dto.isChecked(), dto.isSelected());
        Assertions.assertTrue(dto.isChecked());
    }

    @Test
    public void buildingCheckboxStateWithAllFields() {
        CheckboxStateDTO dto = CheckboxStateDTO.builder()
                .isDisplayed(true)
                .text("Accept terms")
                .id("terms-checkbox")
                .color("#333333")
                .backgroundColor("#ffffff")
                .borderColor("#cccccc")
                .width(20)
                .height(20)
                .x(100)
                .y(50)
                .isSelected(false)
                .isEnabled(true)
                .name("agreement")
                .ariaLabel("Accept terms and conditions")
                .labelText("I accept the terms and conditions")
                .build();

        Assertions.assertTrue(dto.isDisplayed());
        Assertions.assertEquals("Accept terms", dto.getText());
        Assertions.assertEquals("terms-checkbox", dto.getId());
        Assertions.assertEquals("#333333", dto.getColor());
        Assertions.assertEquals("#ffffff", dto.getBackgroundColor());
        Assertions.assertEquals("#cccccc", dto.getBorderColor());
        Assertions.assertEquals(20, dto.getWidth());
        Assertions.assertEquals(20, dto.getHeight());
        Assertions.assertEquals(100, dto.getX());
        Assertions.assertEquals(50, dto.getY());
        Assertions.assertFalse(dto.isSelected());
        Assertions.assertTrue(dto.isEnabled());
        Assertions.assertEquals("agreement", dto.getName());
        Assertions.assertEquals("Accept terms and conditions", dto.getAriaLabel());
        Assertions.assertEquals("I accept the terms and conditions", dto.getLabelText());
        Assertions.assertFalse(dto.isChecked());
    }

    @Test
    public void equalsDTOsWithBaseField() {
        CheckboxStateDTO dto1 = CheckboxStateDTO.builder()
                .id("test-id")
                .build();

        CheckboxStateDTO dto2 = CheckboxStateDTO.builder()
                .id("test-id")
                .build();

        Assertions.assertEquals(dto1, dto2);
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void equalsDTOsWithCheckboxField() {
        CheckboxStateDTO dto1 = CheckboxStateDTO.builder()
                .name("terms")
                .isSelected(true)
                .build();

        CheckboxStateDTO dto2 = CheckboxStateDTO.builder()
                .name("terms")
                .isSelected(true)
                .build();

        Assertions.assertEquals(dto1, dto2);
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void equalsDTOsWithDifferentValuesShouldNotBeEqual() {
        CheckboxStateDTO dto1 = CheckboxStateDTO.builder()
                .id("checkbox-1")
                .isSelected(false)
                .build();

        CheckboxStateDTO dto2 = CheckboxStateDTO.builder()
                .id("checkbox-2")
                .isSelected(true)
                .build();

        Assertions.assertNotEquals(dto1, dto2);
    }

    @Test
    public void testIsCheckedMethod() {
        CheckboxStateDTO selectedDto = CheckboxStateDTO.builder()
                .isSelected(true)
                .build();

        CheckboxStateDTO notSelectedDto = CheckboxStateDTO.builder()
                .isSelected(false)
                .build();

        Assertions.assertTrue(selectedDto.isChecked());
        Assertions.assertFalse(notSelectedDto.isChecked());
    }
}

