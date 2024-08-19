package faang.school.hashmap.catchingevents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

}
