package faang.school.godbless.BJS2_12899;

import java.util.List;

public class Music {

    public static void main(String[] args) {
        Thread playThread = new Thread(() -> new Player().play());
        Thread pauseThread = new Thread(() -> new Player().pause());
        Thread skipThread = new Thread(() -> new Player().skip());
        Thread previousThread = new Thread(() -> new Player().previous());

        List<Thread> threads = List.of(playThread, pauseThread, skipThread, previousThread);

        threads.forEach(Thread::run);
    }
}
