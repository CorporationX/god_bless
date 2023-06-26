package faang.school.godbless.kxnvg.analysis;

public enum ActionType {
    POST("post"), COMMENT("comment"), LIKE("like"), SHARE("share");

    private String type;

    ActionType(String type) {
        this.type = type;
    }
}
