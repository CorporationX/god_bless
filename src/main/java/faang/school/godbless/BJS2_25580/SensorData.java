package faang.school.godbless.BJS2_25580;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
public class SensorData {
    private final LocalDateTime dateTime = LocalDateTime.now();
    private final double power;
    private final double voltage;
}
