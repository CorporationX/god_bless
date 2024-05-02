package faang.school.godbless.async.carry;

import java.util.Objects;

public record Item(String name, int power) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return power == item.power && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power);
    }
}
