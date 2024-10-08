package school.faang.streamevent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
