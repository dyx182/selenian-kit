package com.github.dyx182.selenian_kit.integration;

import com.codeborne.selenide.Selenide;
import com.github.dyx182.state_kit.element_state.ElementState;
import com.github.dyx182.state_kit.element_state.dto.ImageStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class ImageState extends BaseIntegrationTests{

    private final String path = getClass().getResource("/pages/test-page.html").toString();

    @Test
    public void checkAttributeImage() {
        Selenide.open(path);

        ImageStateDTO imageState = ElementState.image($x("//img[@id='validImage']"));

        Assertions.assertAll(
                () -> Assertions.assertEquals("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='100' height='50'%3E%3Crect width='100' height='50' fill='blue'/%3E%3Ctext x='10' y='30' fill='white'%3ETest%3C/text%3E%3C/svg%3E",
                        imageState.getSrc(), "src mismatch"),
                () -> Assertions.assertEquals("Test Image", imageState.getAlt(), "alt mismatch"),
                () -> Assertions.assertEquals("This is a test image", imageState.getTitle(), "title mismatch"),
                () -> Assertions.assertEquals("Valid test image for accessibility", imageState.getAriaLabel(), "ariaLabel mismatch"),
                () -> Assertions.assertEquals("Valid Image:", imageState.getLabelText(), "labelText mismatch"),
                () -> Assertions.assertTrue(imageState.isDisplayed(), "isDisplayed should be true"),
                () -> Assertions.assertEquals("", imageState.getText(), "text should be empty for image"),
                () -> Assertions.assertEquals("validImage", imageState.getId(), "id mismatch"),
                () -> Assertions.assertNotNull(imageState.getColor(), "color should not be null"),
                () -> Assertions.assertNotNull(imageState.getBackgroundColor(), "backgroundColor should not be null"),
                () -> Assertions.assertNotNull(imageState.getBorderColor(), "borderColor should not be null"),
                () -> Assertions.assertTrue(imageState.getWidth() > 0, "width should be > 0"),
                () -> Assertions.assertTrue(imageState.getHeight() > 0, "height should be > 0"),
                () -> Assertions.assertTrue(imageState.getX() >= 0, "x should be >= 0"),
                () -> Assertions.assertTrue(imageState.getY() >= 0, "y should be >= 0")
        );
    }
}
