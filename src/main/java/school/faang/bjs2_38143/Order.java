package school.faang.bjs2_38143;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private int id;
    private Status status;

    public enum Status {
        NEW, PROCESSED, COMPLETED
    }
}
