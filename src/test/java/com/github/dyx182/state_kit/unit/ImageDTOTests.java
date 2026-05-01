package com.github.dyx182.state_kit.unit;

import com.github.dyx182.state_kit.element_state.dto.ImageStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImageDTOTests {

    @Test
    public void buildingImageStateWithAllFields() {
        ImageStateDTO dto = ImageStateDTO.builder()
                .isDisplayed(true)
                .text("Logo image")
                .id("main-logo")
                .color("#333333")
                .backgroundColor("#ffffff")
                .borderColor("transparent")
                .width(200)
                .height(100)
                .x(50)
                .y(30)
                .src("/images/logo.png")
                .alt("Company Logo")
                .title("Click to go home")
                .ariaLabel("Main company logo")
                .labelText("LabelText")
                .build();

        Assertions.assertTrue(dto.isDisplayed());
        Assertions.assertEquals("Logo image", dto.getText());
        Assertions.assertEquals("main-logo", dto.getId());
        Assertions.assertEquals("#333333", dto.getColor());
        Assertions.assertEquals("#ffffff", dto.getBackgroundColor());
        Assertions.assertEquals("transparent", dto.getBorderColor());
        Assertions.assertEquals(200, dto.getWidth());
        Assertions.assertEquals(100, dto.getHeight());
        Assertions.assertEquals(50, dto.getX());
        Assertions.assertEquals(30, dto.getY());
        Assertions.assertEquals("/images/logo.png", dto.getSrc());
        Assertions.assertEquals("Company Logo", dto.getAlt());
        Assertions.assertEquals("Click to go home", dto.getTitle());
        Assertions.assertEquals("Main company logo", dto.getAriaLabel());
        Assertions.assertEquals("LabelText", dto.getLabelText());
    }

    @Test
    public void buildingImageStateWithMinimalFields() {
        ImageStateDTO dto = ImageStateDTO.builder()
                .isDisplayed(true)
                .src("/images/icon.png")
                .build();

        Assertions.assertTrue(dto.isDisplayed());
        Assertions.assertEquals("/images/icon.png", dto.getSrc());
    }


    @Test
    public void equalsDTOsWithBaseField() {
        ImageStateDTO dto1 = ImageStateDTO.builder()
                .id("test-id")
                .build();

        ImageStateDTO dto2 = ImageStateDTO.builder()
                .id("test-id")
                .build();

        Assertions.assertEquals(dto1, dto2);
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void equalsDTOsWithImageField() {
        ImageStateDTO dto1 = ImageStateDTO.builder()
                .src("/images/logo.png")
                .alt("Logo")
                .build();

        ImageStateDTO dto2 = ImageStateDTO.builder()
                .src("/images/logo.png")
                .alt("Logo")
                .build();

        Assertions.assertEquals(dto1, dto2);
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void equalsDTOsWithDifferentValuesShouldNotBeEqual() {
        ImageStateDTO dto1 = ImageStateDTO.builder()
                .id("img-1")
                .src("/images/logo.png")
                .build();

        ImageStateDTO dto2 = ImageStateDTO.builder()
                .id("img-2")
                .src("/images/icon.png")
                .build();

        Assertions.assertNotEquals(dto1, dto2);
    }

    @Test
    public void notEqualsDTOsWithSameSrcDifferentAlt() {
        ImageStateDTO dto1 = ImageStateDTO.builder()
                .src("/images/photo.jpg")
                .alt("Photo 1")
                .build();

        ImageStateDTO dto2 = ImageStateDTO.builder()
                .src("/images/photo.jpg")
                .alt("Photo 2")
                .build();

        Assertions.assertNotEquals(dto1, dto2);
    }
}