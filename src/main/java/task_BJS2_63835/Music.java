package task_BJS2_63835;

import java.util.ArrayList;
import java.util.List;

public class Music {
    private static final List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        Player player = new Player(false);
        Thread firstThread = new Thread(player::play);
        Thread secondThread = new Thread(player::pause);
        Thread thirdThread = new Thread(player::skip);
        Thread fourthThread = new Thread(player::previous);

        threads.add(firstThread);
        threads.add(secondThread);
        threads.add(thirdThread);
        threads.add(fourthThread);

        threads.stream().forEach(Thread::start);

    }
}
