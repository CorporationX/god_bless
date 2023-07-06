package faang.school.godbless.supportAnimals;

import java.util.concurrent.atomic.AtomicInteger;

public class Organization {
    private final AtomicInteger balance = new AtomicInteger(0);

    public void addDonation(Donation donation) {
        int amount = donation.getAmount();
        balance.addAndGet(amount);
        System.out.println("Пожертвование ID: " + donation.getId() + ", Сумма: " + amount);
    }

    public int getBalance() {
        return balance.get();
    }

}
