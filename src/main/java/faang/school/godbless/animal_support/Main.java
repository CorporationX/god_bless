package faang.school.godbless.animal_support;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();
        Random random = new Random();
        for (int i = 1; i <= 5; i++) {
            final int donationId = i;
            final int donationAmount = random.nextInt(901) + 100;
            Donation donation = new Donation(donationId, donationAmount);

            Thread thread = new Thread(() -> {
                organization.addDonation(donation);
            });
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Итоговый баланс организации: " + organization.getBalance());
    }
}
