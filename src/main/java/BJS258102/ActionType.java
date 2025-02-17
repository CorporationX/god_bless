package BJS258102;

public enum ActionType {
    POST("Post"),
    COMMENT("Comment"),
    LIKE("Like"),
    SHARE("Share");

    private final String name;

    ActionType(String name) {
        this.name = name;
    }

    public String getActionName() {
        return name;
    }
}
