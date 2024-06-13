package faang.school.godbless.catching.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StreamEvent {

    private int id;
    private String eventType;
    private String data;

}
