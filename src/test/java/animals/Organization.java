package animals;

import java.util.concurrent.CopyOnWriteArrayList;

public class Organization {
    private CopyOnWriteArrayList<Donation> balans;

    public Organization() {
        this.balans = new CopyOnWriteArrayList<>();
    }

    public CopyOnWriteArrayList<Donation> getBalans() {
        return new CopyOnWriteArrayList<>(balans);
    }

    public void addDonation(Donation donation) {
        balans.add(donation);
    }
}
