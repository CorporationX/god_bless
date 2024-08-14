package faang.school.godbless.BJS2_20287;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Data {
    private int id;
    private String value;
    private LocalDateTime timestamp;
}
