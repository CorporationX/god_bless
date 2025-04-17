package school.faang.bjs2_72288;

public record IntegerPair(int firstValue, int secondValue) {
    public int getSum() {
        return firstValue() + secondValue();
    }
}
