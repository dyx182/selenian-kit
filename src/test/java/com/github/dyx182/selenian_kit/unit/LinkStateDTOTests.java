package com.github.dyx182.selenian_kit.unit;

import com.github.dyx182.selenian_kit.element_state.dto.LinkStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkStateDTOTests {
    @Test
    public void buildingLinkStateWithAllFields() {
        LinkStateDTO dto = LinkStateDTO.builder()
                .isDisplayed(true)
                .text("Click here")
                .id("main-link")
                .color("#0066cc")
                .backgroundColor("transparent")
                .borderColor("none")
                .width(100)
                .height(20)
                .x(50)
                .y(30)
                .href("https://example.com")
                .target("_blank")
                .ariaLabel("Go to example")
                .title("Opens in new tab")
                .labelText("LabelText")
                .build();

        Assertions.assertTrue(dto.isDisplayed());
        Assertions.assertEquals("Click here", dto.getText());
        Assertions.assertEquals("main-link", dto.getId());
        Assertions.assertEquals(100, dto.getWidth());
        Assertions.assertEquals("https://example.com", dto.getHref());
        Assertions.assertEquals("_blank", dto.getTarget());
        Assertions.assertEquals("Go to example", dto.getAriaLabel());
        Assertions.assertEquals("Opens in new tab", dto.getTitle());
        Assertions.assertEquals("LabelText", dto.getLabelText());
    }

    @Test
    public void buildingLinkStateWithMinimalFields() {
        LinkStateDTO dto = LinkStateDTO.builder()
                .isDisplayed(true)
                .text("Home")
                .href("/home")
                .build();

        Assertions.assertTrue(dto.isDisplayed());
        Assertions.assertEquals("Home", dto.getText());
        Assertions.assertEquals("/home", dto.getHref());
        Assertions.assertNull(dto.getTarget());
    }

    @Test
    public void equalsDTOsWithBaseField() {
        LinkStateDTO dto1 = LinkStateDTO.builder()
                .id("test")
                .build();

        LinkStateDTO dto2 = LinkStateDTO.builder()
                .id("test")
                .build();

        Assertions.assertEquals(dto1, dto2);
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void equalsDTOsWithLinkField() {
        LinkStateDTO dto1 = LinkStateDTO.builder()
                .href("https://example.com")
                .target("_blank")
                .build();

        LinkStateDTO dto2 = LinkStateDTO.builder()
                .href("https://example.com")
                .target("_blank")
                .build();

        Assertions.assertEquals(dto1, dto2);
        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void equalsDTOsWithDifferentHrefShouldNotBeEqual() {
        LinkStateDTO dto1 = LinkStateDTO.builder()
                .href("/page1")
                .build();

        LinkStateDTO dto2 = LinkStateDTO.builder()
                .href("/page2")
                .build();

        Assertions.assertNotEquals(dto1, dto2);
    }

    @Test
    public void equalsDTOsWithDifferentTargetShouldNotBeEqual() {
        LinkStateDTO dto1 = LinkStateDTO.builder()
                .href("https://example.com")
                .target("_blank")
                .build();

        LinkStateDTO dto2 = LinkStateDTO.builder()
                .href("https://example.com")
                .target("_self")
                .build();

        Assertions.assertNotEquals(dto1, dto2);
    }
}
