package school.faang.meta;


import lombok.Data;

@Data
public class Notification {
    private final NotificationType type;
    private final String message;
}
