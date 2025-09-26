package school.faang.bjs2_93185;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@Setter
public class Order {
    private final int id;
    private TypeOrder status;
}
