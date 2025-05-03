package school.faang.support_animals;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Organization {
    private final Queue<Donation> balance = new ConcurrentLinkedDeque<>();

    public void addDonation(Donation donation) {
        balance.add(donation);
    }

    public double sumDonation() {
        return balance.stream()
                .mapToDouble(Donation::amount)
                .sum();
    }

    public void printAll() {
        System.out.println(balance.size());
        balance.forEach(System.out::println);
    }
}