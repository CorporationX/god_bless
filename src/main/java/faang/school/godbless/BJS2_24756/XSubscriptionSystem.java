package faang.school.godbless.BJS2_24756;

import java.util.Random;

public class XSubscriptionSystem {
    private final Random random = new Random();

    private void addFollower(XAccount account) {
        account.increment();
    }

    public void followAccount(XAccount account) {
        try {
            Thread.sleep((1 + random.nextInt(5)) * 100L);
        } catch (InterruptedException e) {
            throw new RuntimeException("Sleep error");
        }
        addFollower(account);
        System.out.println(Thread.currentThread().getName());
    }
}
