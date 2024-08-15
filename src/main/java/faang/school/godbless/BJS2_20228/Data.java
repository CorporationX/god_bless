package faang.school.godbless.BJS2_20228;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@EqualsAndHashCode
@ToString
public class Data {
    private final Long id;
    private String value;
    @EqualsAndHashCode.Exclude
    private LocalDateTime timestamp;

    public Data(Long id, String value) {
        this.id = id;
        this.value = value;
        this.timestamp = LocalDateTime.now();
    }

    public void updateTimestamp() {
        this.timestamp = LocalDateTime.now();
    }
}
