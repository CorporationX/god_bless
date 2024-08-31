package faang.school.godbless.BJS2_25595;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class Participant {
    private final String name;
    private final Conference conference;
    private final Random random = new Random();

    public void joinConference() {
        try {
            Thread.sleep(1000 * (1 + random.nextInt(5)));
        } catch (InterruptedException e) {
            throw new RuntimeException("sleep error");
        }
        conference.getCountDownLatch().countDown();
        System.out.println(name + " join to conference");
    }
}
