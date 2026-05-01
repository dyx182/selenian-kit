package com.github.dyx182.state_kit.integration;

import com.codeborne.selenide.Selenide;
import com.github.dyx182.state_kit.element_state.ElementState;
import com.github.dyx182.state_kit.element_state.dto.LinkStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class LinkIntegrationTests extends BaseIntegrationTests {

    private final String path = getClass().getResource("/pages/test-page.html").toString();

    @Test
    public void checkLinkAttributes() {
        Selenide.open(path);

        LinkStateDTO linkState = ElementState.link($x("//a[@id='internalLink']"));

        Assertions.assertAll(
                () -> Assertions.assertTrue(linkState.isDisplayed(), "isDisplayed should be true"),
                () -> Assertions.assertTrue(linkState.getHref().endsWith("#section1"),
                        "href should end with #section1, but was: " + linkState.getHref()),
                () -> Assertions.assertEquals("_self", linkState.getTarget(), "target mismatch"),
                () -> Assertions.assertEquals("Navigate to section 1", linkState.getAriaLabel(), "ariaLabel mismatch"),
                () -> Assertions.assertEquals("Click to go to Section 1", linkState.getTitle(), "title mismatch"),
                () -> Assertions.assertEquals("Internal Link:", linkState.getLabelText(), "labelText mismatch"),
                () -> Assertions.assertTrue(linkState.isEnabled(), "isEnabled should be true"),
                () -> Assertions.assertEquals("Go to Section 1", linkState.getText(), "text mismatch"),
                () -> Assertions.assertEquals("internalLink", linkState.getId(), "id mismatch"),
                () -> Assertions.assertNotNull(linkState.getColor(), "color should not be null"),
                () -> Assertions.assertNotNull(linkState.getBackgroundColor(), "backgroundColor should not be null"),
                () -> Assertions.assertNotNull(linkState.getBorderColor(), "borderColor should not be null"),
                () -> Assertions.assertTrue(linkState.getWidth() > 0, "width should be > 0"),
                () -> Assertions.assertTrue(linkState.getHeight() > 0, "height should be > 0"),
                () -> Assertions.assertTrue(linkState.getX() >= 0, "x should be >= 0"),
                () -> Assertions.assertTrue(linkState.getY() >= 0, "y should be >= 0")
        );
    }
}
