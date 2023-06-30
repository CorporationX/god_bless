package faang.school.godbless.finallyNormalGame;

import java.util.Arrays;
import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        List<String> namesOfPigs = Arrays.asList("Ниф-Ниф", "Нуф-Нуф", "Наф-Наф");
        for (int i = 0; i < 3; i++) {
            var thread = new Thread(new PigThread(namesOfPigs.get(i), i));
            thread.start();
            thread.join();
            System.out.println("дом построен для поросенка " + namesOfPigs.get(i));
        }
        System.out.println("Игра завершена!");
    }
}
