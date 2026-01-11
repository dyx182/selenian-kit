package com.github.dyx182.selenian_kit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
@Value
public class CheckboxStateDTO {

    boolean isSelected;
    boolean isEnabled;
    boolean isDisplayed;

    String text;
    String labelText;
    String id;
    String name;
    String ariaLabel;
    String color;
    String backgroundColor;
    String borderColor;

    int width;
    int height;
    int x;
    int y;

    public boolean isChecked() {
        return isSelected;
    }
}
