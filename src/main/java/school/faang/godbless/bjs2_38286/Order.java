package school.faang.godbless.bjs2_38286;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private int id;
    private Status status;

    public enum Status {
        NEW, PROCESSED, ERROR
    }
}
