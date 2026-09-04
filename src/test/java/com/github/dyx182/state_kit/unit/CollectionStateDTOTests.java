package com.github.dyx182.state_kit.unit;

import com.github.dyx182.state_kit.element_state.dto.BaseElementStateDTO;
import com.github.dyx182.state_kit.element_state.dto.CheckboxStateDTO;
import com.github.dyx182.state_kit.element_state.dto.CollectionStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionStateDTOTests {

    @Test
    public void buildingCollectionStateWithAllFields() {
        BaseElementStateDTO first = BaseElementStateDTO.builder()
                .isDisplayed(true)
                .text("Alpha")
                .id("row1")
                .color("#000000")
                .backgroundColor("#ffffff")
                .borderColor("#cccccc")
                .labelText("Label")
                .width(100)
                .height(30)
                .x(10)
                .y(20)
                .build();
        BaseElementStateDTO second = BaseElementStateDTO.builder()
                .isDisplayed(true)
                .text("Beta")
                .id("row2")
                .build();

        CollectionStateDTO<BaseElementStateDTO> dto = CollectionStateDTO.<BaseElementStateDTO>builder()
                .elements(Arrays.asList(first, second))
                .build();

        Assertions.assertEquals(2, dto.getSize());
        Assertions.assertFalse(dto.isEmpty());
        Assertions.assertEquals(Arrays.asList(first, second), dto.getElements());
        Assertions.assertEquals("row1", dto.getElements().get(0).getId());
        Assertions.assertEquals("Alpha", dto.getElements().get(0).getText());
        Assertions.assertEquals("#000000", dto.getElements().get(0).getColor());
        Assertions.assertEquals("#ffffff", dto.getElements().get(0).getBackgroundColor());
        Assertions.assertEquals("#cccccc", dto.getElements().get(0).getBorderColor());
        Assertions.assertEquals("Label", dto.getElements().get(0).getLabelText());
        Assertions.assertEquals(100, dto.getElements().get(0).getWidth());
        Assertions.assertEquals(30, dto.getElements().get(0).getHeight());
        Assertions.assertEquals(10, dto.getElements().get(0).getX());
        Assertions.assertEquals(20, dto.getElements().get(0).getY());
        Assertions.assertTrue(dto.getElements().get(0).isDisplayed());
    }

    @Test
    public void buildingCollectionStateWithTypedElements() {
        List<CheckboxStateDTO> elements = Arrays.asList(
                CheckboxStateDTO.builder().id("box1").isSelected(true).build(),
                CheckboxStateDTO.builder().id("box2").isSelected(false).build()
        );

        CollectionStateDTO<CheckboxStateDTO> dto = CollectionStateDTO.<CheckboxStateDTO>builder()
                .elements(elements)
                .build();

        Assertions.assertEquals(2, dto.getSize());
        Assertions.assertFalse(dto.isEmpty());
        Assertions.assertEquals("box1", dto.getElements().get(0).getId());
        Assertions.assertTrue(dto.getElements().get(0).isSelected());
    }

    @Test
    public void buildingCollectionStateWithEmptyElements() {
        CollectionStateDTO<BaseElementStateDTO> dto = CollectionStateDTO.<BaseElementStateDTO>builder()
                .elements(Collections.emptyList())
                .build();

        Assertions.assertEquals(0, dto.getSize());
        Assertions.assertTrue(dto.isEmpty());
        Assertions.assertTrue(dto.getElements().isEmpty());
    }

    @Test
    public void buildingCollectionStateWithNullElements() {
        CollectionStateDTO<BaseElementStateDTO> dto = CollectionStateDTO.<BaseElementStateDTO>builder()
                .build();

        Assertions.assertEquals(0, dto.getSize());
        Assertions.assertTrue(dto.isEmpty());
        Assertions.assertNull(dto.getElements());
    }

    @Test
    public void equalsDTOsWithSameValuesShouldBeEqual() {
        List<BaseElementStateDTO> elements = Arrays.asList(
                BaseElementStateDTO.builder().id("row1").build()
        );

        CollectionStateDTO<BaseElementStateDTO> dto1 = CollectionStateDTO.<BaseElementStateDTO>builder()
                .elements(elements)
                .build();

        CollectionStateDTO<BaseElementStateDTO> dto2 = CollectionStateDTO.<BaseElementStateDTO>builder()
                .elements(elements)
                .build();

        Assertions.assertEquals(dto1, dto2);
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void equalsDTOsWithDifferentValuesShouldNotBeEqual() {
        CollectionStateDTO<BaseElementStateDTO> dto1 = CollectionStateDTO.<BaseElementStateDTO>builder()
                .elements(Collections.singletonList(BaseElementStateDTO.builder().id("row1").build()))
                .build();

        CollectionStateDTO<BaseElementStateDTO> dto2 = CollectionStateDTO.<BaseElementStateDTO>builder()
                .elements(Collections.singletonList(BaseElementStateDTO.builder().id("row2").build()))
                .build();

        Assertions.assertNotEquals(dto1, dto2);
    }
}
