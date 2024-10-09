package school.faang.Meta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Notification {
    String type;
    String message;
}
