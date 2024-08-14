package faang.school.godbless.cacheLRU;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter @Setter
public class Data {
    private int id;
    private String value;
    private LocalDateTime timestamp;

}
