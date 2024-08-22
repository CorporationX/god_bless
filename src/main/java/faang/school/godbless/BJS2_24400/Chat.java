package faang.school.godbless.BJS2_24400;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chat {
    private static Random rand = new Random();
    private User user1;
    private User user2;

    public void communicate() {
        System.out.printf("Открыт чат для %s с %s%n", user1, user2);
        try {
            Thread.sleep(getCommunicateTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Закрыт чат для %s с %s%n", user1, user2);
    }

    private long getCommunicateTime() {
        return rand.nextLong(5_000, 10_000);
    }
}
