package faang.school.godbless.BJS2_20366;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Data {
    private int id;
    private String value;
    private LocalDateTime timestamp;
}
