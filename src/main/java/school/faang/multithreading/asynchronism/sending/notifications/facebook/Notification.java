package school.faang.multithreading.asynchronism.sending.notifications.facebook;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    private final int id;
    private String message;
}
