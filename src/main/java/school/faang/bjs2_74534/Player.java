package school.faang.bjs2_74534;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private final String name; //(имя игрока)
    private final Integer level; // (уровень игрока),
    private Integer experience; // (опыт игрока).

    public synchronized Player addExperience(Integer delta) {
        this.experience += delta;
        return this;
    }
}
