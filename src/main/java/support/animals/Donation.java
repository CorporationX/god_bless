package support.animals;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Donation {
    private final long id = System.nanoTime();
    private final long donate;
}
