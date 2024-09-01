package faang.school.godbless.heroes.multithreading.sprint.creature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class Creature {
    protected int power;
    protected String name;

    public Creature(int power) {
        this.power = power;
    }
}
