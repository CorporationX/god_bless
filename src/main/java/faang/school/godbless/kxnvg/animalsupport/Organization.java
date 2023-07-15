package faang.school.godbless.kxnvg.animalsupport;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

public class Organization {

    @Getter
    private AtomicInteger balance;

    public Organization() {
        balance = new AtomicInteger(0);
    }

    public void addDonation(Donation donation) {
        balance.getAndAdd(donation.getAmount());
        System.out.println("Общий баланс организации увеличен на: " + donation.getAmount());
    }
}
