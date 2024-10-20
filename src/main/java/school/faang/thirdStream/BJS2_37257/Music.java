package school.faang.thirdStream.BJS2_37257;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        List<Thread> users = List.of(
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::play),
                new Thread(player::skip),
                new Thread(player::previous),
                new Thread(player::pause),
                new Thread(player::pause)
        );

        users.forEach(Thread::start);

        users.forEach(u -> {
            try {
                u.join();
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван");
                e.printStackTrace();
            }
        });
    }
}
