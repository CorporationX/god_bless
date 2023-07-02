package faang.school.godbless.finallyNormalGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PigThread extends Thread {
    private String pigName;
    private int material;
}