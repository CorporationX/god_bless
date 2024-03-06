package faang.school.godbless.supportanimals3254;

import lombok.Getter;

@Getter
public class Donation {
    private long id;
    private int amount;
    private static int counter;

    public Donation(int amount) {
        this.id = ++counter;
        this.amount = amount;
    }
}
