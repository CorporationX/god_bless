package school.faang.task45571;

public record Coordinates(int row, int column) {
    public Coordinates {
        validate(row, column);

    }

    private void validate(int row, int column) {
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException("Coordinates can`t be less than 0");
        }
    }
}
