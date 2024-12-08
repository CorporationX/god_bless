package school.faang.sprint_1.task_bjs44693;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum SpellType {
    ATTACK("Применение колдовских чар"),
    DEFENCE("Защита от чужих чар");

    private final String action;
}
