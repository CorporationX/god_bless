package school.faang.socialnetworkuseranalysis;

public enum ActionType {
    POST("post"),
    COMMENT("comment"),
    LIKE("like"),
    SHARE("like");

    private final String value;

    ActionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

