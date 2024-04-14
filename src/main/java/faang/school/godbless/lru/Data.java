package faang.school.godbless.lru;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Data {
    private int id;
    private String value;
    private LocalDateTime timestamp;
}
