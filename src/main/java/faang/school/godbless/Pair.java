package faang.school.godbless;

public class Pair {

    private final int a;
    private final int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.a + this.b);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair pair)) {
            return false;
        }
        return (this.a == pair.a && this.b == pair.b) || (this.a == pair.b && this.b == pair.a);
    }

    @Override
    public String toString() {
        return this.a + " " + this.b;
    }
}
