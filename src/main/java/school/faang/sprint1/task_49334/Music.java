package school.faang.sprint1.task_49334;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        List<Thread> listThreads = List.of(playThread, pauseThread, skipThread, previousThread);
        for (Thread thread : listThreads) {
            thread.start();
        }
    }
}
