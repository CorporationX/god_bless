package school.faang.sprint1_2.bjs2_81095;

public enum ActionType {
    POST("пост"),
    COMMENT("комментарий"),
    LIKE("лайк"),
    SHARE("поделится");

    private final String title;

    ActionType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
