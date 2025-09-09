package school.faang.bjs2_87622;

public record Notification(NotificationType type, String message) {

    public enum NotificationType {
        SMS, EMAIL, PUSH
    }
}