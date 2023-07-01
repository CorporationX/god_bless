package faang.school.godbless.sprint3.goodgame;

import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        List<String> pigs = List.of("Ниф-Ниф", "Нуф-Нуф", "Наф-Наф");
        Thread thread = null;
        for (int i = 0; i < 3; i++) {
            thread = new Thread(new Pig1Thread(pigs.get(i), i));
            thread.start();
        }
        thread.join();
        System.out.println("Игра завершена!");
    }
}
