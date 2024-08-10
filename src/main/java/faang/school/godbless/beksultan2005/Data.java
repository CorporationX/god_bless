package faang.school.godbless.beksultan2005;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Data {
    private long id;
    private String value;
    private Instant currentDate;

    public Data(long id, String value, LocalDate currentDate) {
        this.id = id;
        this.value = value;
        this.currentDate = Instant.now();
    }
}
