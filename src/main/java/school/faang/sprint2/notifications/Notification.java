package school.faang.sprint2.notifications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
@Getter
public class Notification {
    private String type;
    private String message;


}