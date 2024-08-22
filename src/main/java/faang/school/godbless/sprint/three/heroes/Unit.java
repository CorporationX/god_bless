package faang.school.godbless.sprint.three.heroes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public abstract class Unit {
    private int power;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getClass());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
