package faang.school.godbless.sprint3.goodgame;

import java.util.Arrays;
import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        List<String> pigs = Arrays.asList("Ниф-Ниф", "Нуф-Нуф", "Наф-Наф");
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Pig1Thread(pigs.get(i), i));
            thread.start();
            thread.join();
        }
        System.out.println("Игра завершена!");
    }
}
