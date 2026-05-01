package com.github.dyx182.state_kit.element_state.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@EqualsAndHashCode
public class BaseElementStateDTO {

    boolean isDisplayed;
    String text;
    String id;
    String color;
    String backgroundColor;
    String borderColor;
    String labelText;
    int width;
    int height;
    int x;
    int y;
}
