package faang.school.godbless.Army_Sorted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Archer implements Warrior {
    private int power;

    @Override
    public int getPower() {
        return power;
    }
}
