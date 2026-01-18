package com.github.dyx182.selenian_kit.element_state.dto;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ImageStateDTO extends BaseElementStateDTO{
    String src;
    String alt;
    String title;
    String ariaLabel;
}
