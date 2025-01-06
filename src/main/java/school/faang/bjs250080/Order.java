package school.faang.bjs250080;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Order {
    private final int id;
    @Setter
    private Status status;
}
