package faang.school.godbless.java.sql.lru;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class Data {

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

    private int id;
    private String value;
    private LocalDateTime timestamp;

    @Override
    public String toString() {
        return String.format("{%d, %s, %s}", this.id, this.value, this.timestamp.format(Constants.CUSTOM_FORMATTER));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return id == data.id && Objects.equals(value, data.value) && Objects.equals(timestamp, data.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, timestamp);
    }
}
