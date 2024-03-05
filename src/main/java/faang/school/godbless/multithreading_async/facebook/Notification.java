package faang.school.godbless.multithreading_async.facebook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Notification {
    private int id;
    private String message;
}
