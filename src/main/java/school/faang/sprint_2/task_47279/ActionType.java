package school.faang.sprint_2.task_47279;

public enum ActionType {
    POST("post"),
    COMMENT("comment"),
    LIKE("like"),
    SHARE("share");

    private final String title;

    ActionType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
