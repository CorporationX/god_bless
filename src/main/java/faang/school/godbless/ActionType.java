package faang.school.godbless;

public enum ActionType {
    POST("post"),
    COMMENT("comment"),
    LIKE("like"),
    SHARE("share");

    private String typeText;

    ActionType(String typeText) {
        this.typeText = typeText;
    }
}