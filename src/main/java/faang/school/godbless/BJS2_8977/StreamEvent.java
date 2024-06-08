package faang.school.godbless.BJS2_8977;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class StreamEvent {
    private int id;
    @ToString.Include(name = "Тип события")
    private String eventType;
    @ToString.Include(name = "Данные события")
    private String data;
}
