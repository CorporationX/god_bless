package faang.school.godbless.wow;

public enum Difficult {
    HIGH("hight"),
    LOW("low"),
    MIN("min");

    private String title;

    Difficult(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
