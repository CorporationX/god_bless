package faang.school.godbless.sprint_2.meta_universe;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    private String type;
    private String message;
}