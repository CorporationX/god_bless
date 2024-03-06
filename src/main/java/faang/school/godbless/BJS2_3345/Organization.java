package faang.school.godbless.BJS2_3345;


import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Organization {
    private final AtomicInteger atomicIntegerBalance = new AtomicInteger();
    private Integer integerBalance = 0;
    private int intBalance = 0;
    private final static int DONATIONS_NUM = 1000;

    public void addDonation(Donation donation) {
        atomicIntegerBalance.addAndGet(donation.getValue());
        integerBalance += donation.getValue();
        intBalance += donation.getValue();
        System.out.println("Accept donation " + donation.getId());
    }

    /*
    Result with DONATIONS_NUM = 1000000

    AtomicInteger: 1000000
    Integer: 978737
    int: 997359
    Last donation id: 1000000
    */

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Organization organization = new Organization();
        for (int i = 0; i < DONATIONS_NUM; i++) {
            executorService.execute(() -> organization.addDonation(new Donation(1)));
        }
        executorService.shutdown();
        try {
            boolean isFinished = executorService.awaitTermination(60, TimeUnit.SECONDS);
            if (isFinished) {
                System.out.println("AtomicInteger: " + organization.getAtomicIntegerBalance());
                System.out.println("Integer: " + organization.getIntegerBalance());
                System.out.println("int: " + organization.getIntBalance());
                System.out.println("Last donation id: " + Donation.lastId);
            } else {
                System.out.println("Not all threads are finished");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
