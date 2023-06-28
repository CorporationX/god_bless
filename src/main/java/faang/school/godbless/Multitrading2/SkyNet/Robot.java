package faang.school.godbless.Multitrading2.SkyNet;

import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;


@AllArgsConstructor
public class Robot {

    private volatile static AtomicInteger countMurders = new AtomicInteger(0);
    private String target;

    public static AtomicInteger getCountMurders() {
        return countMurders;
    }

    public synchronized void attack() {
        System.out.println("Robot attacked " + target + " " + Thread.currentThread().getName());
        System.out.println("Target " + target + " is dead");
        countMurders.incrementAndGet();
    }
}
