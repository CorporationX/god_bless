package faang.school.godbless.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Notification {
    private String type;
    @Setter
    private String message;
}
