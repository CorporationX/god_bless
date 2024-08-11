package faang.school.godbless.javahashmap.task5;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class StreamEvent {
    private Integer id;
    private String eventType;
    private String data;
}
