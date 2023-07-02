package faang.school.godbless.finallyNormalGame;

import java.util.Arrays;
import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        List<String> namesOfPigs = List.of("Ниф-Ниф", "Нуф-Нуф", "Наф-Наф");
        List<Integer> material = List.of(1, 2, 3);
        for (int i = 0; i < 3; i++) { // три потока
            var thread = new PigThread(namesOfPigs.get(i), material.get(i)); // каждому поросенку свой поток
            thread.join(); // ожидаем завершения каждого потока (запускаются друг за другом)
            thread.start();
            System.out.println("дом построен для поросенка: " + namesOfPigs.get(i) + " ,из материала: " + material.get(i));
        }
        System.out.println("Игра завершена!");
    }
}
