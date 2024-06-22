package faang.school.godbless.streamApi.streamApi2;

import lombok.Data;

@Data
public class PersonPair {
    private final String a;
    private final String b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonPair that = (PersonPair) o;

        return a.equals(that.a) && b.equals(that.b) || a.equals(that.b) && b.equals(that.a);
    }

    @Override
    public int hashCode() {
        int resultA = a != null ? a.hashCode() : 0;
        int resultB = b != null ? b.hashCode() : 0;
        int result = resultA + resultB;
        return 31 * result + result;
    }

    @Override
    public String toString() {
        return "[" + a + ", " + b + "]";
    }
}
