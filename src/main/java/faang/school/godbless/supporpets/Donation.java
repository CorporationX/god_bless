package faang.school.godbless.supporpets;

import lombok.Getter;

@Getter
public class Donation {
    private static int idFromDB;
    private final int id;
    private final int amount;

    public Donation(int amount) {
        this.amount = amount;
        this.id = ++idFromDB;
    }
}
