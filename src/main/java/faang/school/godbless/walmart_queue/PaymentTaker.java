package faang.school.godbless.walmart_queue;

import lombok.Data;

@Data
public class PaymentTaker {
    private int money = 0;

    public void addMoney(int moneyToAdd) {
        money += moneyToAdd;
    }
}
