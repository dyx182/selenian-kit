package com.github.dyx182.state_kit.element_state.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

@Value
@Builder
@EqualsAndHashCode
public class CollectionStateDTO<T extends BaseElementStateDTO> {

    List<T> elements;

    public int getSize() {
        return elements == null ? 0 : elements.size();
    }

    public boolean isEmpty() {
        return elements == null || elements.isEmpty();
    }
}
