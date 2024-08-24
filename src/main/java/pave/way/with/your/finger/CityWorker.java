package pave.way.with.your.finger;

import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class CityWorker implements Runnable {
    private final static long MAX_TIME_TO_KILL = 2000;
    private final City city;
    private final List<Monster> monsters;
    @Getter
    private AtomicLong result = new AtomicLong(0);

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    public Optional<Monster> findNearestMonster(City city, List<Monster> monsters) {
        return monsters.stream()
            .min(Comparator.comparingDouble(m -> city.getLocation().distanceTo(m.getLocation())));
    }

    public long getKillTime() {
        return new Random().nextLong(MAX_TIME_TO_KILL);
    }

    public long getJourneyDistance() {
        return this.city.getDistanceToWither();
    }

    @Override
    public void run() {
        Optional<Monster> nearestMonster = this.findNearestMonster(this.city, this.monsters);
        if (nearestMonster.isEmpty()) {
            System.out.printf("Не найдено монстров для города %s\n", this.city.getName());
            return;
        }

        long killTime = this.getKillTime();
        long timeUsed = killTime + this.getJourneyDistance();

        System.out.printf(
            "Геральт отправился в %s и устраняет %s\n",
            city.getName(),
            nearestMonster.get().getName()
        );

        try {
            Thread.sleep(timeUsed);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        System.out.printf("Геральт осилил монстра за %s время\n", killTime);

        this.result = new AtomicLong(timeUsed);
    }
}
