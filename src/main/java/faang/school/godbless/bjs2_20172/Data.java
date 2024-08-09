package faang.school.godbless.bjs2_20172;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
public class Data {
    private int id;
    private String value;
    private LocalDateTime timestamp;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return id == data.id && Objects.equals(value, data.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
