package faang.school.godbless.CatchEvents;

import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;

//    public StreamEvent(String data, String eventType) {
//        this.data = data;
//        this.eventType = eventType;
//    }
//
//    private StreamEvent(int id, String eventType, String data) {
//        this.id = id;
//        this.eventType = eventType;
//        this.data = data;
//    }

    private String data;

}
