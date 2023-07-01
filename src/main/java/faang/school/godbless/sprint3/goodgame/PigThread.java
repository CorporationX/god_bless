package faang.school.godbless.sprint3.goodgame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PigThread extends Thread {
    private String pigName;
    private int material;

    @Override
    public void run() {
        System.out.println(String.format("%s build house with %s", pigName, material));
    }
}
