package school.faang.bjs2_87365.character;

public record Item(String name, int value) {
    public String toString() {
        return String.format("Предмет: %s | Стоимость: %d", name, value);
    }
}
