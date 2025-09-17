package bjs2_91259;

import java.util.*;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> results = Collections.synchronizedList(new ArrayList<>());

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> {
                int power = squad.calculateSquadPower();
                System.out.println("Сила отряда: " + power);
                results.add(power);
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return results.stream().mapToInt(Integer::intValue).sum();
    }
}