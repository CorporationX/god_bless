package school.faang.sprint_1.task_armyofheroesbjs2n47795;

import lombok.Getter;

import java.util.List;

@Getter
public class  PowerCalculator <T extends Warrior> implements Runnable {
    List<T> warriors;
    private int sum;

    public PowerCalculator(List<T> warriors) {
        this.warriors = warriors;
        this.sum = 0;
    }

    @Override
    public void run() {
            this.sum = calculatePower();
    }

    public  int calculatePower() {
        int sum = 0;
        for (T warrior : warriors) {
            sum += warrior.getPower();
        }
        return sum;
    }
}
