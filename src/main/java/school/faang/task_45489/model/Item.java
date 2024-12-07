package school.faang.task_45489.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum Item {
    RING(1000),
    SWORD(1500);

    private final int value;
}