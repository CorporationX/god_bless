package faang.school.godbless.BJS2_25267;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            int id = 1;
            executor.submit(() -> organization.addDonation(new Donation(id, id * 10)));
        }
        executor.shutdown();

        System.out.println("Total balance: " + organization.getBalanceMoney());
    }
}
