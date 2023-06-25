package faang.school.godbless.normalgame;

import lombok.SneakyThrows;

public class ThreeLittlePigs {

    @SneakyThrows
    public static void main(String[] args) {
        Pig1Thread thread1 = new Pig1Thread("Ниф-Ниф", "солома");
        Pig2Thread thread2 = new Pig2Thread("Наф-Наф", "палки");
        Pig3Thread thread3 = new Pig3Thread("Нуф-Нуф", "кирпичи");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("=== Игра завершена! ===");
    }
}
