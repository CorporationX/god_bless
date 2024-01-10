package faang.school.godbless.alexbulgakoff.multithreading.async.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */

@AllArgsConstructor
@Getter
@ToString
public class Player {
    private String name;
    private int level;
    @Setter
    private int experience;
}
