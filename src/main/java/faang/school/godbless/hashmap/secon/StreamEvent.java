package faang.school.godbless.hashmap.secon;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}