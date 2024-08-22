package faang.school.godbless.heroes.sprint3.creature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Dwarf extends Creature {
    private String name = "dwarf";

    public Dwarf(int power) {
        super(power);
    }
}
