package faang.school.godbless.multithreading.normal_game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    protected String pigName;
    protected String material;

    @Override
    public void run() {
        System.out.println("Поросенок " + pigName + " строит дом из материала - " + material);
    }

    public void done() {
        System.out.println("Поросенок " + pigName + " построил свой дом из материала - " + material);
    }
}
