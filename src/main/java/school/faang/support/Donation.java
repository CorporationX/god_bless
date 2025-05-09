package school.faang.support;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Donation {
    private final int id;
    private final double amount;
}
