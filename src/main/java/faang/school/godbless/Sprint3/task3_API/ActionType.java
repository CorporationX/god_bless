package faang.school.godbless.Sprint3.task3_API;

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