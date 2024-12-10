package school.faang.task_46785;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class Notification {
    private String type;
    @Setter
    private String message;

}
