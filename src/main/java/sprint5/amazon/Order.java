package sprint5.amazon;

import lombok.Data;

@Data
public class Order {
    private final long id;
    private boolean status = false;
}
