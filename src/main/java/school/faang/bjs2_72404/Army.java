package school.faang.bjs2_72404;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class Army {
    List<Squad> squadList;

    public void calculateTotalPower() {
        AtomicInteger sum = new AtomicInteger();
        for (int i = 0; i < squadList.size(); i++) {
            int finalI = i;
            new Thread(() -> sum.addAndGet(squadList.get(finalI).calculateSquadPower())).start();
        }
    }
}
