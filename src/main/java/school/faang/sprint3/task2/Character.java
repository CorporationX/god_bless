package school.faang.sprint3.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public abstract class Character {
    private int power;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Character character = (Character) o;
        return getPower() == character.getPower();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPower());
    }
}
