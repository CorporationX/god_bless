package faang.school.godbless.SupportAnimals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@NoArgsConstructor
public class Organization {
    @Getter
    private AtomicInteger balance = new AtomicInteger(0);

    public void addDonation(int amount) {
        balance.getAndAdd(amount);
    }
}
