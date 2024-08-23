package faang.school.godbless.sprint.three.heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public abstract class Unit {
    private int power;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + this.getPower();
    }
}
