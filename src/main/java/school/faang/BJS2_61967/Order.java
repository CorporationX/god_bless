package school.faang.BJS2_61967;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Order {
    private int id;
    private String status;

    @Getter
    public enum Status {
        NEW, PROCESSED, CANCELLED
    }
}