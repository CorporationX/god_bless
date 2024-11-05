package school.faang.tracking.system;

public enum Status {
    BUSY("Занят"),
    FREE("Свободен");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }


    @Override
    public String toString() {
        return displayName;
    }
}
