package school.faang.m1.future.amazone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    int id;
    Status status;

    public enum Status {
        NEW,
        PROCESSED
    }
}
