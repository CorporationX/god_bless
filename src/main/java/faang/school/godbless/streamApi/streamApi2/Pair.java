package faang.school.godbless.streamApi.streamApi2;

import lombok.Data;

@Data
public class Pair {
    private final int a;
    private final int b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        return (a == pair.a && b == pair.b) || (a == pair.b && b == pair.a);
    }

    @Override
    public int hashCode() {
        int result = a + b;
        result = 31 * result + result;
        return result;
    }

    @Override
    public String toString() {
        return "[" + a + ", " + b + "]";
    }
}
