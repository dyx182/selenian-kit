package com.github.dyx182.selenian_kit.element_state.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BaseElementStateDTO {

    boolean isDisplayed;
    String text;
    String id;
    String color;
    String backgroundColor;
    String borderColor;
    int width;
    int height;
    int x;
    int y;
}
