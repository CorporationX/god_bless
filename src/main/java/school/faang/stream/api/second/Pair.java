package school.faang.stream.api.second;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Pair {
    private final int first;
    private final int second;
    private final int sum;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
        sum = first + second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return first == pair.first && second == pair.second ||
                first == pair.second && second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sum);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
