package school.faang.heroes.of.might.and.magic;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Army {
    private final List<Squad> squads;

    public Army() {
        this.squads = new ArrayList<>();
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<PowerThread> powerThreads = new ArrayList<>();

        for (Squad squad : squads) {
            PowerThread powerThread = new PowerThread(squad);
            powerThreads.add(powerThread);
            powerThread.start();
        }

        int totalPower = 0;
        for (PowerThread thread : powerThreads) {
            thread.join();
            totalPower += thread.getPower();
        }

        return totalPower;
    }
}