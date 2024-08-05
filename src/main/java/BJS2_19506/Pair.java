package BJS2_19506;

import lombok.ToString;

import java.util.Objects;

@ToString
public class Pair {
    private String first;
    private int second;

    public Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return getSecond() == pair.getSecond() && Objects.equals(getFirst(), pair.getFirst());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond());
    }
}
