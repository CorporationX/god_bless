package faang.school.godbless.CatchTheEvents;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String data;
    private String eventType;
    @Override
    public String toString() {
        return "StreamEvent{id=" + id + ", data='" + data + "', eventType='" + eventType + "'}";
    }
}
