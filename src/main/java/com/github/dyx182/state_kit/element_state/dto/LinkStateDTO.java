package com.github.dyx182.state_kit.element_state.dto;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class LinkStateDTO extends BaseElementStateDTO{
    boolean isEnabled;
    String href;
    String target;
    String ariaLabel;
    String title;
}
