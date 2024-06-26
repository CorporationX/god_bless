package faang.school.godbless.distributedArmyOfHeroes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SubdivisionThred implements Runnable {
    private Subdivision subdivision;
    private int powerSubdivision;

    public SubdivisionThred(Subdivision subdivision) {
        this.subdivision = subdivision;
    }

    @Override
    public void run() {
        powerSubdivision = subdivision.getPower();
    }
}