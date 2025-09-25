package school.faang.bjs2_93707;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Organization organization = new Organization();
        List<Thread> threads = List.of(
                new Thread(() -> organization.addDonation((new Donation(1, 150)))),
                new Thread(() -> organization.addDonation((new Donation(2, 180)))),
                new Thread(() -> organization.addDonation((new Donation(3, 615)))),
                new Thread(() -> organization.addDonation((new Donation(4, 215)))),
                new Thread(() -> organization.addDonation((new Donation(5, 550)))),
                new Thread(() -> organization.addDonation((new Donation(6, 500))))
        );
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        log.info("Все операции завершились. Итоговая сумма: {}", organization.getBalance());
    }
}
