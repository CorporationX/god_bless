package school.faang.bjs2_80501;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Notification {
    private NotificationType type;
    private String message;
}
