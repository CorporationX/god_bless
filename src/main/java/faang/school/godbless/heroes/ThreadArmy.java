package faang.school.godbless.heroes;

import lombok.Getter;

@Getter
public class ThreadArmy extends Thread {
    private Warriors warriors;
    private int allPower;

    public ThreadArmy(Warriors warriors) {
        this.warriors = warriors;
    }

    @Override
    public void run() {
        allPower = warriors.getPower() * warriors.getCount();
    }
}
