package faang.school.godbless.sprint_3.finally_good_game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class PigThread extends Thread {
    private String pigName;
    private int material;
}
