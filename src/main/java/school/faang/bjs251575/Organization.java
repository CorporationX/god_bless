package school.faang.bjs251575;

import java.util.concurrent.atomic.DoubleAdder;

public class Organization {

    private DoubleAdder balance = new DoubleAdder();

    public void addDonation(double amount) {
        try {
            Thread.sleep(1_000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        balance.add(amount);
    }

    public double getBalance() {
        return balance.sum();
    }

}
