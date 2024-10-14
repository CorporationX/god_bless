package school.faang.heroes;

import lombok.Getter;

import java.util.List;


public class PowerCalculator extends Thread {
    private final List<Warrior> warriors;

    @Getter
    int result;

    public PowerCalculator(List<Warrior> warriors) {
        this.warriors = warriors;
    }

    @Override
    public void run() {
        result = warriors.stream().mapToInt(Warrior::getPower).sum();
    }

}
