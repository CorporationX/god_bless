package school.faang.heroesofmightandmagic.units;

import lombok.Getter;

import java.util.List;
import java.util.ArrayList;

@Getter
public class Army {
    private List<Squad> squadList = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        List<SquadPowerThread> threads = new ArrayList<>();
        for (Squad squad : squadList) {
            SquadPowerThread squadPowerThread = new SquadPowerThread(squad);
            threads.add(squadPowerThread);
            squadPowerThread.start();
        }

        for (SquadPowerThread thread : threads) {
            thread.join();
        }
        int totalPower = 0;
        for (SquadPowerThread thread : threads) {
            totalPower += thread.getResult();
        }

        return totalPower;
    }

    public void addSquad(Squad squad) {
        squadList.add(squad);
    }
}
