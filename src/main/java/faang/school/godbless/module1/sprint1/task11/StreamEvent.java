package faang.school.godbless.module1.sprint1.task11;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class StreamEvent {
    private int id;
    private String event;
    private String data;
}
