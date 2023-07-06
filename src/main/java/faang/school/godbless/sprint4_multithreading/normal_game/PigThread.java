package faang.school.godbless.sprint4_multithreading.normal_game;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PigThread extends Thread{
    private String pigName;
    private int material;
}
