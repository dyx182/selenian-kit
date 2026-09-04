package com.github.dyx182.state_kit.element_state;

import com.codeborne.selenide.SelenideElement;
import com.github.dyx182.state_kit.element_state.dto.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public final class ElementState {

    private ElementState() {
    }

    public static CheckboxStateDTO checkbox(SelenideElement element) {
        return CheckboxState.getState(element);
    }

    public static InputStateDTO input(SelenideElement element) {
        return InputState.getState(element);
    }

    public static ButtonStateDTO button(SelenideElement element) {
        return ButtonState.getState(element);
    }

    public static ImageStateDTO image(SelenideElement element) {
        return ImageState.getState(element);
    }

    public static LinkStateDTO link(SelenideElement element) {
        return LinkState.getState(element);
    }

    public static SelectStateDTO select(SelenideElement element) {
        return SelectState.getState(element);
    }

    public static final class collection {

        private collection() {
        }

        public static CollectionStateDTO<BaseElementStateDTO> elementsCollection(Collection<SelenideElement> elements) {
            List<BaseElementStateDTO> states = new ArrayList<>();
            for (SelenideElement element : elements) {
                states.add(BaseState.getState(element));
            }
            return buildCollection(states);
        }

        public static CollectionStateDTO<CheckboxStateDTO> checkboxes(Collection<SelenideElement> elements) {
            List<CheckboxStateDTO> states = new ArrayList<>();
            for (SelenideElement element : elements) {
                states.add(CheckboxState.getState(element));
            }
            return buildCollection(states);
        }

        public static CollectionStateDTO<ButtonStateDTO> buttons(Collection<SelenideElement> elements) {
            List<ButtonStateDTO> states = new ArrayList<>();
            for (SelenideElement element : elements) {
                states.add(ButtonState.getState(element));
            }
            return buildCollection(states);
        }

        public static CollectionStateDTO<InputStateDTO> inputs(Collection<SelenideElement> elements) {
            List<InputStateDTO> states = new ArrayList<>();
            for (SelenideElement element : elements) {
                states.add(InputState.getState(element));
            }
            return buildCollection(states);
        }

        public static CollectionStateDTO<ImageStateDTO> images(Collection<SelenideElement> elements) {
            List<ImageStateDTO> states = new ArrayList<>();
            for (SelenideElement element : elements) {
                states.add(ImageState.getState(element));
            }
            return buildCollection(states);
        }

        public static CollectionStateDTO<LinkStateDTO> links(Collection<SelenideElement> elements) {
            List<LinkStateDTO> states = new ArrayList<>();
            for (SelenideElement element : elements) {
                states.add(LinkState.getState(element));
            }
            return buildCollection(states);
        }

        public static CollectionStateDTO<SelectStateDTO> selects(Collection<SelenideElement> elements) {
            List<SelectStateDTO> states = new ArrayList<>();
            for (SelenideElement element : elements) {
                states.add(SelectState.getState(element));
            }
            return buildCollection(states);
        }

        private static <T extends BaseElementStateDTO> CollectionStateDTO<T> buildCollection(List<T> states) {
            return CollectionStateDTO.<T>builder()
                    .elements(states)
                    .build();
        }
    }
}
