package derschrank.sprint02.task02.bjstwo_46670;

import lombok.Getter;

import java.util.function.Consumer;

@Getter
public enum NotificationType {
    EMAIL((notification) -> System.out.println("Sending E-mail: " + notification.getMessage())),
    SMS((notification) -> System.out.println("Sending SMS: " + notification.getMessage())),
    PUSH((notification) -> System.out.println("Push: " + notification.getMessage()));

    private final Consumer<Notification> sender;

    NotificationType(Consumer<Notification> consumer) {
        this.sender = consumer;
    }
}
