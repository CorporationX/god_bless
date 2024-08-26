package faang.school.godbless.heroes.multithreading.sprint.creature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Dwarf extends Creature {
    private final String name = "dwarf";

    public Dwarf(int power) {
        super(power);
    }
}
