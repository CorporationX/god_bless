package school.faang.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    private String type;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
}
