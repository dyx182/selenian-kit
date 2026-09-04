package com.github.dyx182.state_kit.integration;

import com.codeborne.selenide.Selenide;
import com.github.dyx182.state_kit.element_state.ElementState;
import com.github.dyx182.state_kit.element_state.dto.BaseElementStateDTO;
import com.github.dyx182.state_kit.element_state.dto.ButtonStateDTO;
import com.github.dyx182.state_kit.element_state.dto.CheckboxStateDTO;
import com.github.dyx182.state_kit.element_state.dto.CollectionStateDTO;
import com.github.dyx182.state_kit.element_state.dto.ImageStateDTO;
import com.github.dyx182.state_kit.element_state.dto.InputStateDTO;
import com.github.dyx182.state_kit.element_state.dto.LinkStateDTO;
import com.github.dyx182.state_kit.element_state.dto.SelectStateDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$x;

public class CollectionIntegrationTests extends BaseIntegrationTests {

    private final String path = getClass().getResource("/pages/test-page.html").toString();

    @Test
    public void checkCheckboxCollection() {
        Selenide.open(path);

        CollectionStateDTO<CheckboxStateDTO> checkboxes = ElementState.collection.checkboxes($$x("//input[@name='groupOptions']"));

        Assertions.assertAll(
                () -> Assertions.assertEquals(3, checkboxes.getSize(), "size mismatch"),
                () -> Assertions.assertFalse(checkboxes.isEmpty(), "isEmpty should be false"),
                () -> Assertions.assertEquals(3, checkboxes.getElements().size(), "elements size mismatch"),
                () -> Assertions.assertTrue(checkboxes.getElements().get(0).isSelected(), "first checkbox should be selected"),
                () -> Assertions.assertFalse(checkboxes.getElements().get(1).isSelected(), "second checkbox should not be selected"),
                () -> Assertions.assertFalse(checkboxes.getElements().get(2).isEnabled(), "third checkbox should be disabled"),
                () -> Assertions.assertEquals("Group option one", checkboxes.getElements().get(0).getLabelText(), "labelText mismatch"),
                () -> Assertions.assertEquals("groupCheckbox2", checkboxes.getElements().get(1).getId(), "id mismatch")
        );
    }

    @Test
    public void checkGenericRowsCollection() {
        Selenide.open(path);

        CollectionStateDTO<BaseElementStateDTO> tableState = ElementState.collection.elementsCollection($$x("//table[@id='dataTable']//tbody//tr"));

        Assertions.assertAll(
                () -> Assertions.assertEquals(3, tableState.getSize(), "size mismatch"),
                () -> Assertions.assertFalse(tableState.isEmpty(), "isEmpty should be false"),
                () -> Assertions.assertEquals(3, tableState.getElements().size(), "elements size mismatch"),
                () -> Assertions.assertEquals("tableRow1", tableState.getElements().get(0).getId(), "first row id mismatch"),
                () -> Assertions.assertTrue(tableState.getElements().get(0).isDisplayed(), "first row should be displayed"),
                () -> Assertions.assertTrue(tableState.getElements().get(0).getText().contains("Alpha"), "row text mismatch")
        );
    }

    @Test
    public void checkLinksCollection() {
        Selenide.open(path);

        CollectionStateDTO<LinkStateDTO> links = ElementState.collection.links($$x("//ul//li//a"));

        Assertions.assertAll(
                () -> Assertions.assertEquals(3, links.getSize(), "size mismatch"),
                () -> Assertions.assertFalse(links.isEmpty(), "isEmpty should be false"),
                () -> Assertions.assertEquals(3, links.getElements().size(), "elements size mismatch"),
                () -> Assertions.assertTrue(links.getElements().get(0).getHref().endsWith("#one"),
                        "href should end with #one, but was: " + links.getElements().get(0).getHref()),
                () -> Assertions.assertEquals("First link", links.getElements().get(0).getText(), "text mismatch"),
                () -> Assertions.assertTrue(links.getElements().get(1).isDisplayed(), "second link should be displayed")
        );
    }

    @Test
    public void checkButtonsCollection() {
        Selenide.open(path);

        CollectionStateDTO<ButtonStateDTO> buttons = ElementState.collection.buttons($$x("//button"));

        Assertions.assertAll(
                () -> Assertions.assertEquals(4, buttons.getSize(), "size mismatch"),
                () -> Assertions.assertEquals("register", buttons.getElements().get(0).getName(), "first button name mismatch"),
                () -> Assertions.assertTrue(buttons.getElements().get(0).isEnabled(), "first button should be enabled"),
                () -> Assertions.assertFalse(buttons.getElements().get(3).isEnabled(), "disabled button should not be enabled")
        );
    }

    @Test
    public void checkInputsCollection() {
        Selenide.open(path);

        CollectionStateDTO<InputStateDTO> inputs = ElementState.collection.inputs($$x("//input[@type='text']"));

        Assertions.assertAll(
                () -> Assertions.assertEquals(5, inputs.getSize(), "size mismatch"),
                () -> Assertions.assertEquals("textInput", inputs.getElements().get(0).getId(), "first input id mismatch"),
                () -> Assertions.assertEquals("username", inputs.getElements().get(0).getName(), "first input name mismatch"),
                () -> Assertions.assertEquals("testuser", inputs.getElements().get(0).getValue(), "first input value mismatch")
        );
    }

    @Test
    public void checkImagesCollection() {
        Selenide.open(path);

        CollectionStateDTO<ImageStateDTO> images = ElementState.collection.images($$x("//img"));

        Assertions.assertAll(
                () -> Assertions.assertEquals(2, images.getSize(), "size mismatch"),
                () -> Assertions.assertEquals("validImage", images.getElements().get(0).getId(), "first image id mismatch"),
                () -> Assertions.assertEquals("Test Image", images.getElements().get(0).getAlt(), "first image alt mismatch")
        );
    }

    @Test
    public void checkSelectsCollection() {
        Selenide.open(path);

        CollectionStateDTO<SelectStateDTO> selects = ElementState.collection.selects($$x("//select"));

        Assertions.assertAll(
                () -> Assertions.assertEquals(3, selects.getSize(), "size mismatch"),
                () -> Assertions.assertEquals("singleSelect", selects.getElements().get(0).getId(), "first select id mismatch"),
                () -> Assertions.assertEquals("United Kingdom", selects.getElements().get(0).getSelectedOption(), "first select selected option mismatch")
        );
    }

    @Test
    public void checkEmptyCollection() {
        Selenide.open(path);

        CollectionStateDTO<BaseElementStateDTO> empty = ElementState.collection.elementsCollection($$x("//tr[@id='nonexistent']"));

        Assertions.assertAll(
                () -> Assertions.assertEquals(0, empty.getSize(), "size mismatch"),
                () -> Assertions.assertTrue(empty.isEmpty(), "isEmpty should be true"),
                () -> Assertions.assertTrue(empty.getElements().isEmpty(), "elements should be empty")
        );
    }
}
