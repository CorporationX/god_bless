package school.faang.metaWorld;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Notification {
    private String type;
    private String message;
}
