package faang.school.godbless.multi_paral.task8normal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread{
    private String pigName;
    private int material;
}
