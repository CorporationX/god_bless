package school.faang.task422.donation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Donation {
    private int id;
    private BigDecimal amount;
}
