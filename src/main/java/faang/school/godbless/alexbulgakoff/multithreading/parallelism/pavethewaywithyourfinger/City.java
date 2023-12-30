package faang.school.godbless.alexbulgakoff.multithreading.parallelism.pavethewaywithyourfinger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@ToString
public class City {
    private String name;
    private Location location;
    private int distance;
}
