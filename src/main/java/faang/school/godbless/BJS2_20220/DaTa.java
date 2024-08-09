package faang.school.godbless.BJS2_20220;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DaTa {
    private int id;
    private String value;
    private LocalDateTime timestamp;

    public DaTa(int id, String value, LocalDateTime timestamp) {
        this.id = id;
        this.value = value;
        this.timestamp = timestamp;
    }
}
