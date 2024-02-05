package faang.school.godbless.BJS2_1580;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.concurrent.CountDownLatch;

@AllArgsConstructor
@Data
public class Conference implements Runnable{
    public static final int REQUIRED_PARTICIPANTS = 3;
    private final CountDownLatch latch = new CountDownLatch(REQUIRED_PARTICIPANTS);
    private String name;

    @Override
    public void run() {
        try {
            System.out.printf("Conference is waiting for participant. Required amount = %s \n", REQUIRED_PARTICIPANTS);
            latch.await();
            System.out.print("Conference is started!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}