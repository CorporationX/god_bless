package faang.school.godbless.normal_game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PigThread extends Thread {
    protected String pigName;
    protected int material;
}
