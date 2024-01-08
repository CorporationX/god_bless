package faang.school.godbless.alexbulgakoff.multithreading.async.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@ToString
public class Quest {
    private String name;
    private int difficulty;
    private int reward;
}
