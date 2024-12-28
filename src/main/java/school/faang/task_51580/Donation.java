package school.faang.task_51580;

import lombok.Getter;

@Getter
public class Donation {

    private final int id;
    private final double amount;

    public Donation(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }
}