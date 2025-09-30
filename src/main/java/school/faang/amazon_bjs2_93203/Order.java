package school.faang.amazon_bjs2_93203;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private final int id;
    private Status status;
}
