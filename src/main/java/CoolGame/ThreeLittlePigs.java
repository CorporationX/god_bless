package CoolGame;

import java.util.ArrayList;
import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(new Pig1Thread()));
        threads.add(new Thread(new Pig2Thread()));
        threads.add(new Thread(new Pig3Thread()));
        threads.get(0).start();
        threads.get(1).start();
        threads.get(2).start();

        threads.stream().forEach(thread ->
            {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        System.out.println("The end!");
    }
}
