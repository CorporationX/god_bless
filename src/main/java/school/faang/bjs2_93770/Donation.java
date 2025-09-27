package school.faang.bjs2_93770;

import lombok.Getter;

public class Donation {
    private static int idCounter = 1;
    @Getter private int id;
    @Getter private double amount;

    public Donation(double amount) {
        this.amount = amount;
        id = idCounter;
        idCounter++;
    }
}
