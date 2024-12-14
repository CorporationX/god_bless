package faang.school.godbless.BJS2_20340;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Data {
    private int id;
    private String value;
    @Setter
    private LocalDateTime timestamp;
}
