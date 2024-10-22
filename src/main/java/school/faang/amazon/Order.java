package school.faang.amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Order {
    private int id;
    @Setter
    private String status;
}
