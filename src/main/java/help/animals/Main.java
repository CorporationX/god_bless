package help.animals;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int TIMEOUT = 10;

    public static void main(String[] args) throws InterruptedException {
        final Organization organization = new Organization();

        for (int i = 1; i < 6; i++) {
            int id = i * 314 + 34245;
            double amount = (i * 731) + 32.5;
            new Thread(() -> organization.addDonation(new Donation(id, amount))).start();
        }

        Thread.sleep(TIMEOUT);
        log.info("Total balance after all donations is {}$", organization.getBalance());
    }
}
