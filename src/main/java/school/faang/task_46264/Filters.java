package school.faang.task_46264;

public enum Filters {
    GRAYSCALE("grayscale"),
    SEPIA("sepia"),
    VIGNETTE("vignette");

    private String title;

    Filters(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Filter: "
                + title;
    }
}
