package school.faang.naughtwoBSS256996;

public enum Category {
    FOOD,
    ELECTRONICS,
    CLOTHING,
    OTHER,
    FURNITURE,
    TOYS,
    BOOKS,
    BEAUTY,
    SPORTS,
    AUTOMOTIVE;

    public static boolean isCategoryInEnum(Category category) {
        for (Category constant : Category.values()) {
            if (constant.name().equals(category)) {
                return true;
            }
        }
        return false;
    }
}

