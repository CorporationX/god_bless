package school.faang.m1s3.bjs2_37165_spotify;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        List<Thread> actions = new ArrayList<>(List.of(
                new Thread(() -> player.play()),
                new Thread(() -> player.play()),
                new Thread(() -> player.skip()),
                new Thread(() -> player.play()),
                new Thread(() -> player.pause()),
                new Thread(() -> player.pause()),
                new Thread(() -> player.previous())
        ));

        actions.forEach(Thread::start);

        actions.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        System.out.println(player.getActionsCount());
    }
}
