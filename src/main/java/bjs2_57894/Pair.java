package bjs2_57894;

import java.util.Objects;

public record Pair(String first, String second) {
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Pair.class) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        Pair other = (Pair) obj;
        // Пары равны не зависимо от порядка следования людей в них
        return (first.equals(other.first) && second.equals(other.second))
                || (first.equals(other.second) && second.equals(other.first));
    }

    @Override
    public int hashCode() {
        if (first.compareTo(second) >= 0) {
            return Objects.hash(first, second);
        } else {
            return Objects.hash(second, first);
        }
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", first, second);
    }
}
