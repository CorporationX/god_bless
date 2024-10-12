package school.faang.main_code_catch_events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}