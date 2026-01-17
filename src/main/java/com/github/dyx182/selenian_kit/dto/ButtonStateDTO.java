package com.github.dyx182.selenian_kit.dto;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ButtonStateDTO extends BaseElementStateDTO {
    boolean isEnabled;
    String type;
    String name;
    String value;
    String ariaLabel;
    String form;
}
