package school.faang.notifyinfacebook;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    private int id;
    private String message;
}
