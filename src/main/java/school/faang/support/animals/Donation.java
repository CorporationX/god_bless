package school.faang.support.animals;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Donation {
    private final int id;
    private BigDecimal amount;
}
