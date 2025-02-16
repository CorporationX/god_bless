package school.faang.lets_practice_streamAPI_2.BJS2_58055;

import java.util.Objects;

public record NumberPair(Integer first, Integer second) {
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NumberPair that = (NumberPair) o;
        return (Objects.equals(first, that.first) && Objects.equals(second, that.second)) ||
                (Objects.equals(first, that.second) && Objects.equals(second, that.first));
    }

    @Override
    public int hashCode() {
        return Objects.hash(first + second, first * second);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
