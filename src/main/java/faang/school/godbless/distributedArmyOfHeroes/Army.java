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
        List<Integer> power = new ArrayList<>();

        for (Subdivision subdivision : subdivisions) {
            SubdivisionThred subdivisionThred = new SubdivisionThred(subdivision);
            power.add(subdivision.getPower());
            subdivisionThreds.add(subdivisionThred);
            subdivisionThred.run();
        }

        for (SubdivisionThred subdivisionThred : subdivisionThreds) {
            subdivisionThred.getSubdivision().join(); //тут вопрос
        }

        return power.stream()
                .mapToInt(num -> num)
                .sum();
    }
}