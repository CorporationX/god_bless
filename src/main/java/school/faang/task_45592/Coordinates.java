package school.faang.task_45592;

public record Coordinates(int x, int y) {
    public Coordinates {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Indexes cannot be negative");
        }
    }
}
