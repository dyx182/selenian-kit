package com.github.dyx182.selenian_kit.dto;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class InputStateDTO extends BaseElementStateDTO{
    boolean isEnabled;
    String name;
    String value;
    String placeholder;
    String type;
    String ariaLabel;

}
