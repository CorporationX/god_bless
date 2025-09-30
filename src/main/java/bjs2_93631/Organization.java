package bjs2_93631;

import java.util.concurrent.atomic.DoubleAdder;

class Organization {
    private final DoubleAdder balance = new DoubleAdder();

    public void addDonation(Donation donation) {
        balance.add(donation.getAmount());
        System.out.printf("Пожертвование #%d (%.2f) добавлено. Текущий баланс: %.2f%n",
                donation.getId(), donation.getAmount(), balance.sum());
    }

    public double getBalance() {
        return balance.sum();
    }
}