package school.faang.finallyanormalgame.main;

import school.faang.finallyanormalgame.maincode.Pig1Thread;
import school.faang.finallyanormalgame.maincode.Pig2Thread;
import school.faang.finallyanormalgame.maincode.Pig3Thread;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        Pig1Thread thread1 = new Pig1Thread("ниф ниф", "солом");
        Pig2Thread thread2 = new Pig2Thread("нуф нуф", "дерево");
        Pig3Thread thread3 = new Pig3Thread("наф наф", "кирпичи");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Игра завершена");
    }
}
