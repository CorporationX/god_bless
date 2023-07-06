package faang.school.godbless.homm_army;

import lombok.Data;

import java.util.concurrent.Callable;

@Data
public class Character implements Callable<Integer> {

    private int power;

    public Character() {
    }

    public Character(int power) {
        this.power = power;
    }

    @Override
    public Integer call() {
        return power;
    }
}
