package BJS256905;

public enum Category {
    FOOD("Food"),
    ELECTRONICIS("Electronics"),
    CLOTHING("Clothing"),
    OTHER("Other");
    private final String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName(Category category) {
        return categoryName;
    }

}
