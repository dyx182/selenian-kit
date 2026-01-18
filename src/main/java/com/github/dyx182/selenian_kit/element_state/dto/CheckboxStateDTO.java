package com.github.dyx182.selenian_kit.element_state.dto;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class CheckboxStateDTO extends BaseElementStateDTO{

    boolean isSelected;
    boolean isEnabled;
    String labelText;
    String name;
    String ariaLabel;

    public boolean isChecked() {
        return isSelected;
    }
}
