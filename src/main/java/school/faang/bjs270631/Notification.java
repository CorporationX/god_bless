package school.faang.bjs270631;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Notification {
    private NotificationType notificationType;
    private String message;
}
