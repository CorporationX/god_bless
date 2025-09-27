package school.faang.bjs2_91375;

import lombok.Getter;

public class SquadThread extends Thread {
    @Getter
    private int sumPower = 0;

    public void addPower(int addedPower) {
        sumPower += addedPower;
    }
}
