package school.faang.task_44605;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Type {
    HEAL("Healing user"),
    TRANSFIGURATION("Transforms an item"),
    CURSE("Imposes blindness "),
    DEFEND("Defends from attacks");

    private final String description;
}
