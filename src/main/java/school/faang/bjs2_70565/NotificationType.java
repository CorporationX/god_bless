package school.faang.bjs2_70565;

public enum NotificationType {
    EMAIL("email"),
    SMS("sms"),
    PUSH("push");

    private final String name;

    NotificationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
