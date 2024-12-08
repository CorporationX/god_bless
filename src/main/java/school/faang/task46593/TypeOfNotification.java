package school.faang.task46593;

import lombok.Getter;

@Getter
public enum TypeOfNotification {
    PUSH("push notification"),
    INFORMATION("information notification"),
    PERSONAL("personalized notification"),
    EMAIL("email");

    private final String notification;

    TypeOfNotification(String notification) {
        this.notification = notification;
    }
}
