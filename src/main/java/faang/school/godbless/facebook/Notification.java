package faang.school.godbless.facebook;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    private int id;
    private String message;

    public Notification() {
    }
}
