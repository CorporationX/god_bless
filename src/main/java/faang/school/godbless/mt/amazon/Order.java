package faang.school.godbless.mt.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private int id;
    private Status status;

    public enum Status {
        CREATED, PROCESS, COMPLETED, CANCELED
    }
}
