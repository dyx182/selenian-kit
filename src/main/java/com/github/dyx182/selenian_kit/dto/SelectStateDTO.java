package com.github.dyx182.selenian_kit.dto;

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
    List<String> selectedOptions;
}
