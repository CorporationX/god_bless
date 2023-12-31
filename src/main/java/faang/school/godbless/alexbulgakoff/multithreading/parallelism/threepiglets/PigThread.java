package faang.school.godbless.alexbulgakoff.multithreading.parallelism.threepiglets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */

@AllArgsConstructor
@Getter
@ToString
public class PigThread extends Thread {
    private String pigName;
    private int material;
}
