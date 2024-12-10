package school.faang.bjs246668;

import lombok.Getter;

@Getter
public enum NotificationType {

    EMAIL("email"),
    PUSH("push"),
    SMS("sms");

    private final String name;

    NotificationType(String name) {
        this.name = name;
    }
}