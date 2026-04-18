package com.github.dyx182.selenian_kit.element_state.utils;

import com.codeborne.selenide.SelenideElement;

public class LabelUtils {

    private LabelUtils() {}

    public static String getLabelText(SelenideElement element) {
//todo add exception
        if (element.$x("./preceding-sibling::label").exists() && !element.$x("./preceding-sibling::label").getText().isEmpty()) {
            return element.$x("./preceding-sibling::label").getText();
        } else if (element.$x("./parent::label").exists() && !element.$x("./parent::label" ).getText().isEmpty()) {
            return element.$x("./parent::label").getText();
        } else if (element.$x("./preceding-sibling::span").exists() && !element.$x("./preceding-sibling::span").getText().isEmpty()) {
            return element.$x("./preceding-sibling::span").getText();
        } else if (element.$x("./following-sibling::span").exists() && !element.$x("./following-sibling::span").getText().isEmpty()) {
            return element.$x("./following-sibling::span").getText();
        }
        return "";
    }
}
