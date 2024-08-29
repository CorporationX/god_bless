package faang.school.godbless.SupportAnimals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Organization {
    @Getter
    private volatile Balance balance = new Balance(0);

    public void addDonation(int amount) {
        balance = new Balance(balance.getBalance() + amount);
    }
}
