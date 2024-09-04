package faang.school.godbless.donations;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();

        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            int donationAmount = i * 100;
            Donation donation = new Donation(donationAmount);

            Thread thread = new Thread(() -> {
                organization.addDonation(donation);
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Итоговый баланс организации: " + organization.getBalance());
    }
}
