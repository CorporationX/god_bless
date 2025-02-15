package bjs257936;

import lombok.Getter;

@Getter
public enum NotificationType {
    EMAIL("EMAIL"), SMS("SMS"), PUSH("PUSH");

    private final String text;

    NotificationType(String text) {
        this.text = text;
    }
}
