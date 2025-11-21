package school.faang.dontionAnimals;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Donation {
    private final int id;
    private final double amount;
}
