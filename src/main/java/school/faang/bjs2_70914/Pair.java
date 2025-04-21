package school.faang.bjs2_70914;

public record Pair<T>(T firstValue, T secondValue) {
    @Override
    public String toString() {
        return String.format("(%s, %s)", firstValue, secondValue);
    }
}