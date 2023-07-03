package faang.school.godbless.Sprint4.Fine_game;

import java.util.LinkedList;
import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        List<PigThread> pigs = List.of(new Pig1Thread("Ниф", 5), new Pig2Thread("Нуф", 3), new Pig3Thread("Наф", 2));
        List<Thread> threads = new LinkedList<>();
        for (int i = 0; i < pigs.size(); i++) {
            threads.add(new Thread(pigs.get(i)));
            threads.get(i).start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("END");
    }

}
