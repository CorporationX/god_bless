package school.faang.bjs2_70818;

public enum ActionType {
    POST ("post"),
    COMMENT ("comment"),
    LIKE ("like"),
    SHARE ("share");

    private String name;

    ActionType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
