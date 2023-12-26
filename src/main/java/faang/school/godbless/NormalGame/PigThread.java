package faang.school.godbless.NormalGame;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    private String pigName;
    private int material;   //не поняла, зачем здесь значение int
}
