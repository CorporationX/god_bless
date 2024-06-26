package faang.school.godbless.wow;

public enum Reward {
    GOLD("gold"),
    SILVER("silver"),
    BRONZE("bronze");

    private String title;

    Reward(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
