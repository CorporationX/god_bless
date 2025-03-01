package school.faang.bjs2_61956;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Order {
    private final int id;
    @Setter
    private String status;
}
