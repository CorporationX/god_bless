package school.faang.BJS2_72305;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Army {

    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        List<Integer> powers = Collections.synchronizedList(new ArrayList<>());
        for (Squad squad : squads) {
            Thread thread = new Thread(() -> {
                System.out.println("Squad " + squad.getName() + " Power: " + squad.calculateSquadPower());
                powers.add(squad.calculateSquadPower());
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        return powers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
