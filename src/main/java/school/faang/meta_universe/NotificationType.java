package school.faang.meta_universe;

public enum NotificationType {
    EMAIL, SMS, PUSH;

    @Override
    public String toString() {
        return name().toUpperCase();
    }
}
