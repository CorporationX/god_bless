package school.faang.task_45116;

public enum Category {
    ELECTRONICS, CLOTHING, FOOD, BOOKS;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
