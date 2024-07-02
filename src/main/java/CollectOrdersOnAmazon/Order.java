package CollectOrdersOnAmazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Order {
    private int id;
    private String status;

    public synchronized void setStatus(String status) {
        this.status = status;
    }
}
