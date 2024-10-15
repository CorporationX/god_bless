package the_queue_at_walmart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Items {
    private String name;
    private int price;
    private int quantity;
}
