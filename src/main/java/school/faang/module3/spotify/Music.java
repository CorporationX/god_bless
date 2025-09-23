package school.faang.module3.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread t1 = new Thread(player::play);
        t1.start();
        Thread t2 = new Thread(player::pause);
        t2.start();
        Thread t3 = new Thread(player::previous);
        t3.start();
        Thread t4 = new Thread(player::skip);
        t4.start();


        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            log.info("All treads completed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("InterruptedException", e);
        }
    }
}
