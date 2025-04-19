package school.faang.streamApi.user_activity;

public enum ActionType {
    POST("Post"),
    LIKE("Like"),
    COMMENT("Comment"),
    SHARE("Share");

    private final String typeName;

    ActionType(String type) {
        this.typeName = type;
    }

    @Override
    public String toString() {
        return this.typeName;
    }
}
