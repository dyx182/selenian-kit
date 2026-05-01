package com.github.dyx182.selenian_kit.unit;

import com.github.dyx182.state_kit.element_state.dto.SelectStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SelectDTOTests {

    @Test
    public void buildingSelectStateWithAllFields() {
        List<String> options = Arrays.asList("Russia", "USA", "Germany");
        List<String> selectedOptions = Arrays.asList("USA");

        SelectStateDTO dto = SelectStateDTO.builder()
                .isDisplayed(true)
                .text("USA")
                .id("country-select")
                .color("#333")
                .backgroundColor("#fff")
                .borderColor("#ccc")
                .width(200)
                .height(35)
                .x(100)
                .y(50)
                .isEnabled(true)
                .name("country")
                .value("us")
                .ariaLabel("Select country")
                .options(options)
                .selectedOption("USA")
                .selectedOptions(selectedOptions)
                .labelText("LabelText")
                .build();

        Assertions.assertTrue(dto.isDisplayed());
        Assertions.assertEquals("USA", dto.getText());
        Assertions.assertEquals("country-select", dto.getId());
        Assertions.assertTrue(dto.isEnabled());
        Assertions.assertEquals("country", dto.getName());
        Assertions.assertEquals(options, dto.getOptions());
        Assertions.assertEquals("USA", dto.getSelectedOption());
        Assertions.assertEquals(selectedOptions, dto.getSelectedOptions());
        Assertions.assertEquals("LabelText", dto.getLabelText());
    }

    @Test
    public void buildingSelectStateWithMinimalFields() {
        SelectStateDTO dto = SelectStateDTO.builder()
                .isDisplayed(true)
                .options(Arrays.asList("A", "B"))
                .build();

        Assertions.assertTrue(dto.isDisplayed());
        Assertions.assertEquals(2, dto.getOptions().size());
    }

    @Test
    public void buildingSelectStateWithMultipleSelectedOptions() {
        List<String> options = Arrays.asList("Red", "Green", "Blue");
        List<String> selectedOptions = Arrays.asList("Red", "Blue");

        SelectStateDTO dto = SelectStateDTO.builder()
                .options(options)
                .selectedOptions(selectedOptions)
                .selectedOption("Red")
                .build();

        Assertions.assertEquals(2, dto.getSelectedOptions().size());
        Assertions.assertTrue(dto.getSelectedOptions().contains("Red"));
        Assertions.assertTrue(dto.getSelectedOptions().contains("Blue"));
        Assertions.assertEquals("Red", dto.getSelectedOption());
    }

    @Test
    public void equalsDTOsWithBaseField() {
        SelectStateDTO dto1 = SelectStateDTO.builder()
                .id("test")
                .build();

        SelectStateDTO dto2 = SelectStateDTO.builder()
                .id("test")
                .build();

        Assertions.assertEquals(dto1, dto2);
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void equalsDTOsWithSelectField() {
        List<String> options = Arrays.asList("A", "B", "C");

        SelectStateDTO dto1 = SelectStateDTO.builder()
                .name("country")
                .options(options)
                .selectedOption("B")
                .build();

        SelectStateDTO dto2 = SelectStateDTO.builder()
                .name("country")
                .options(options)
                .selectedOption("B")
                .build();

        Assertions.assertEquals(dto1, dto2);
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void equalsDTOsWithDifferentSelectedShouldNotBeEqual() {
        List<String> options = Arrays.asList("A", "B", "C");

        SelectStateDTO dto1 = SelectStateDTO.builder()
                .options(options)
                .selectedOption("A")
                .build();

        SelectStateDTO dto2 = SelectStateDTO.builder()
                .options(options)
                .selectedOption("B")
                .build();

        Assertions.assertNotEquals(dto1, dto2);
    }

    @Test
    public void equalsDTOsWithDifferentOptionsShouldNotBeEqual() {
        SelectStateDTO dto1 = SelectStateDTO.builder()
                .options(Arrays.asList("A", "B"))
                .build();

        SelectStateDTO dto2 = SelectStateDTO.builder()
                .options(Arrays.asList("X", "Y"))
                .build();

        Assertions.assertNotEquals(dto1, dto2);
    }
}
