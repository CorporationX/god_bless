package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PigThread extends Thread{
    private String pigName;
    private int material;
}
