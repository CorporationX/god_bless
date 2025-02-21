package school.faang.sprint3.multithreading.bjs2_61400;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Squad<T extends Warrior> implements Runnable {
    private final List<T> warriors;
    private int totalSquadPower;

    public Squad() {
        warriors = new ArrayList<>();
        totalSquadPower = 0;
    }

    public Squad(List<T> warriors) {
        this.warriors = warriors;
        totalSquadPower = calculateSquadPower();
    }

    public int calculateSquadPower() {
        return warriors.stream().mapToInt(Warrior::getPower).sum();
    }

    public void add(T warrior) {
        warriors.add(warrior);
        totalSquadPower = calculateSquadPower();
    }

    @Override
    public void run() {
        totalSquadPower = calculateSquadPower();
    }
}
