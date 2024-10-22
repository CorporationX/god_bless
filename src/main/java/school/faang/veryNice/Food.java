package school.faang.veryNice;

public record Food(String name) {
    @Override
    public String toString() {
        return name;
    }
}