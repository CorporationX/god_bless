package school.faang.HeroesOfMightAndMagic81139;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Squad<T extends Warrior> {
    private List<T> squadList;

    public Squad(String name, List<T> list) {
        this.squadList = new CopyOnWriteArrayList<>(list);
    }

    @Getter
    private int allPower = 0;

    public void calculateSquadPower() {
        AtomicInteger sum = new AtomicInteger(0);
        for (T t : squadList) {
            sum.addAndGet(t.getPower());
        }
        allPower = sum.get();
    }
}
