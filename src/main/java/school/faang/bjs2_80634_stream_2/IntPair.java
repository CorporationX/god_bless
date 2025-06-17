package school.faang.bjs2_80634_stream_2;

public record IntPair(int a, int b) {
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        IntPair other = (IntPair) obj;

        return (this.a == other.a && this.b == other.b)
                || (this.a == other.b && this.b == other.a);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(a) + Integer.hashCode(b);
    }
}
