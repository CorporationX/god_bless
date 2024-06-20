package faang.school.godbless.hashmap.lrucashe;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
public class Data {
    private static int number;
    private int id;
    private String value;
    private LocalDateTime timetemp;

    public Data(String value) {
        number++;
        this.id = number;
        this.value = value;
    }

    public String toString() {
        return "id " + id + ", " + "value " + value + " timetemp " + timetemp;
    }
}
