package school.faang.bjs2_34768;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Notification {
    private final TypeOfNotification type;
    private final String message;

    public enum TypeOfNotification {
     SMS, EMAIL, PUSH, RING
 }
}
