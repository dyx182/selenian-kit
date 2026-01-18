package com.github.dyx182.selenian_kit.element_state.dto;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class SelectStateDTO extends BaseElementStateDTO {
    boolean isEnabled;
    String name;
    String value;
    String ariaLabel;
    List<String> options;
    String selectedOption;
    List<String> selectedOptions;
}
