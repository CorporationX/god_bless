package task_BJS2_63835;

import java.util.ArrayList;
import java.util.List;

public class Music {
    private static final List<Thread> THREADS = new ArrayList<>();

    public static void main(String[] args) {
        Player player = new Player(false);
        Thread firstThread = new Thread(player::play);
        Thread secondThread = new Thread(player::pause);
        Thread thirdThread = new Thread(player::skip);
        Thread fourthThread = new Thread(player::previous);

        THREADS.add(firstThread);
        THREADS.add(secondThread);
        THREADS.add(thirdThread);
        THREADS.add(fourthThread);

        THREADS.forEach(Thread::start);
    }
}
