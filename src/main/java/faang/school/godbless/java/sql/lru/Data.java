package faang.school.godbless.java.sql.lru;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
public class Data {
    private int id;
    private String value;
    private LocalDateTime timestamp;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
        this.timestamp = LocalDateTime.now();
    }

    public Data(int id, String value, String timestamp) {
        this.id = id;
        this.value = value;
        this.timestamp = LocalDateTime.parse(timestamp);
    }

    @Override
    public String toString() {
        return String.format("{%d, %s, %s}", this.id, this.value, this.timestamp.format(Constants.CUSTOM_FORMATTER));
    }

}
