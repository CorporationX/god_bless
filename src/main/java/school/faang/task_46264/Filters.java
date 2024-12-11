package school.faang.task_46264;

public enum Filters {
    GRAYSCALE("черно-белый"),
    SEPIA("сепия"),
    VIGNETTE("виньетка");

    private String title;

    Filters(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Фильтр: "
                + title;
    }
}
