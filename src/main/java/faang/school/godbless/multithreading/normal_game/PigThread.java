package faang.school.godbless.multithreading.normal_game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    protected String pigName;
    protected String material;
}
