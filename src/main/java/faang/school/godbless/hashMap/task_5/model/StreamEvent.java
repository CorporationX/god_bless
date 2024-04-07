package faang.school.godbless.hashMap.task_5.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class StreamEvent {
    private final int id;
    private final String eventType;
    private final String data;
}