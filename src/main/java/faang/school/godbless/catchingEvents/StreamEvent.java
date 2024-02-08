package faang.school.godbless.catchingEvents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@Getter
@ToString
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
