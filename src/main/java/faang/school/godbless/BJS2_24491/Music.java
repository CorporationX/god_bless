package faang.school.godbless.BJS2_24491;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {

        Player player = new Player();

        List<Thread> threadPool = new ArrayList<>();

        threadPool.add(new Thread(player::play));
        threadPool.add(new Thread(player::pause));
        threadPool.add(new Thread(player::skip));
        threadPool.add(new Thread(player::previous));

        for (Thread thread : threadPool){
            thread.start();
        }
    }
}
