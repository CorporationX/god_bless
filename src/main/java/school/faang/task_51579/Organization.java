package school.faang.task_51579;

import java.util.concurrent.atomic.AtomicReference;

public class Organization {
    private final AtomicReference<Double> balance = new AtomicReference<>(0.0);

    public void addDonation(Donation donation) {
        balance.updateAndGet(currentBalance -> currentBalance + donation.getAmount());
        System.out.println("Donation added: " + donation.getAmount() + ", Current Balance: " + balance.get());
    }

    public double getBalance() {
        return balance.get();
    }
}
