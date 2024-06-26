package faang.school.godbless.distributedArmyOfHeroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Subdivision> subdivisions;

    public Army() {
        this.subdivisions = new ArrayList<>();
    }

    public void addUnit(Subdivision subdivision) {
        subdivisions.add(subdivision);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<SubdivisionThred> subdivisionThreds = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        List<Integer> power = new ArrayList<>();

        for (Subdivision subdivision : subdivisions) {
            SubdivisionThred subdivisionThred = new SubdivisionThred(subdivision);
            Thread thread = new Thread(subdivisionThred);
            threads.add(thread);
            subdivisionThreds.add(subdivisionThred);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return subdivisionThreds.stream()
                .mapToInt(SubdivisionThred::getPowerSubdivision)
                .sum();
    }
}