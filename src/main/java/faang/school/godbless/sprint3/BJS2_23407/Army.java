package faang.school.godbless.sprint3.BJS2_23407;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Army {
    private List<Hero> heroes = new ArrayList<>();

    public void addUnit(@NonNull Hero hero) {
        heroes.add(hero);
    }

    public int calculateTotalPower() {
        List<PowerCalculatingThread> threads = new ArrayList<>();
        for (Hero hero : heroes) {
            PowerCalculatingThread thread = new PowerCalculatingThread(hero);
            thread.start();
            threads.add(thread);
        }

        return threads.stream()
                .mapToInt(PowerCalculatingThread::getPower)
                .sum();
    }
}
