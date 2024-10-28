package blockingspotify;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        List<Thread> musicThreads = new ArrayList<>();
        musicThreads.addAll(getListOfThreads(player::play, 2));
        musicThreads.addAll(getListOfThreads(player::pause, 3));
        musicThreads.addAll(getListOfThreads(player::skip, 1));
        musicThreads.addAll(getListOfThreads(player::previous, 4));

        musicThreads.forEach(Thread::start);
    }

    public static List<Thread> getListOfThreads(Runnable task, int threadCount) {
        List<Thread> musicThreads = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            musicThreads.add(new Thread(task));
        }
        return musicThreads;
    }
}
