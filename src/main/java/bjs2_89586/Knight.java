package bjs2_89586;

import java.util.Objects;
import lombok.Getter;

@Getter
public class Knight {
    private final String name;

    public Knight(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Knight knight = (Knight) o;
        return Objects.equals(name, knight.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}