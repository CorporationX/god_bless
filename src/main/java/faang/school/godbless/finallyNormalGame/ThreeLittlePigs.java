package faang.school.godbless.finallyNormalGame;

import java.util.Arrays;
import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        List<String> namesOfPigs = Arrays.asList("Ниф-Ниф", "Нуф-Нуф", "Наф-Наф");
        List<Integer> material = Arrays.asList(1, 2, 3);
        for (int i = 0; i < 3; i++) { // три потока
            var thread = new Thread(new PigThread(namesOfPigs.get(i), material.get(i))); // каждому поросенку свой поток
            thread.start();
            thread.join(); // ожидаем завершшения каждого потока (запускаются друг за другом)
            System.out.println("дом построен для поросенка: " + namesOfPigs.get(i) + " ,из материала: " + material.get(i));
        }
        System.out.println("Игра завершена!");
    }
}
