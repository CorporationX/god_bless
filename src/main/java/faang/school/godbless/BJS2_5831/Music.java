package faang.school.godbless.BJS2_5831;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Player player = new Player();

        threads.add(new Thread(player ::play));
        threads.add(new Thread(player ::pause));
        threads.add(new Thread(player ::skip));
        threads.add(new Thread(player ::previous));

        for (Thread thread : threads) {
            thread.start();
        }
    }
}