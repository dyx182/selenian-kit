package com.github.dyx182.selenian_kit.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CheckboxStateDTO {

    boolean isSelected;
    boolean isEnabled;
    boolean isDisplayed;

    String text;
    String validationMessage;
    String id;
    String name;
    String ariaLabel;

    String color;
    String backgroundColor;
    String borderColor;
    String checkmarkColor;

    int wight;
    int height;
    int x;
    int y;

    public boolean isChecked() {
        return isDisplayed;
    }
}
