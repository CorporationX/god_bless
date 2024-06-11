package faang.school.godbless.shop;

public record Product(int id, String name, String category) {
    public Product {
        validate(id, name, category);
    }

    private void validate(int id, String name, String category) {
        if (id < 1 ||
                name == null || name.trim().isEmpty() ||
                category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Check input data!");
        }
    }
}
