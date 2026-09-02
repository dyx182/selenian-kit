package com.github.dyx182.state_kit.element_state.utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class LabelUtils {

    private static final List<String> LABEL_XPATHS = Arrays.asList(
            "./preceding-sibling::label",
            "./parent::label",
            "./preceding-sibling::span",
            "./following-sibling::span"
    );

    private LabelUtils() {
    }

    /**
     * Возвращает текст подписи элемента (label/span) или пустую строку, если подпись не найдена.
     */
    public static String getLabelText(SelenideElement element) {
        for (String xpath : LABEL_XPATHS) {
            List<WebElement> nodes = element.findElements(By.xpath(xpath));
            if (!nodes.isEmpty()) {
                String text = nodes.get(0).getText();
                if (text != null && !text.isEmpty()) {
                    return text;
                }
            }
        }
        return "";
    }
}
