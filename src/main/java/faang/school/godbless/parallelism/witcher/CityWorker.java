package faang.school.godbless.parallelism.witcher;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

import static faang.school.godbless.parallelism.witcher.Witcher.MIN_KILL_TIME;

@AllArgsConstructor
@Slf4j
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;


    @Override
    public void run() {
        var nearestMonster = findNearestMonster(city, monsters);

        if (nearestMonster.isEmpty()) {
            log.warn("There is no monsters around.");
            return;
        }

        long killTime = getKillTime();

        try {
            Thread.sleep(killTime);
        } catch (InterruptedException e) {
            log.error("Killing monster was interrupted.", e);
            return;
        }

        Monster monster = nearestMonster.get();
        long journeyDistance = getJourneyDistance(monster.location());

        log.info("Nearest monster to " + city.getName() + " is " + monster);
        log.info("Killing time of " + monster + " was: " + killTime / 1000);
        log.info("Journey distance to " + monster + " is: " + journeyDistance + " minutes");
    }

    public Optional<Monster> findNearestMonster(City city, List<Monster> monsters) {
        return monsters.stream().min((monster1, monster2) -> {
            var dx = Math.pow(monster1.location().x() - city.getLocation().x(), 2);
            var dy = Math.pow(monster1.location().y() - city.getLocation().y(), 2);

            var monster1Distance = Math.sqrt(dx + dy);

            dx = Math.pow(monster2.location().x() - city.getLocation().x(), 2);
            dy = Math.pow(monster2.location().y() - city.getLocation().y(), 2);

            var monster2Distance = Math.sqrt(dx + dy);


            return (int) (monster1Distance - monster2Distance);
        });
    }

    public long getKillTime() {
        return MIN_KILL_TIME * 1000L;
    }

    public long getJourneyDistance(Location location) {
        var dx = Math.pow(location.x() - city.getLocation().x(), 2);
        var dy = Math.pow(location.y() - city.getLocation().y(), 2);

        var distance = Math.sqrt(dx + dy);

        return Math.round(city.getDistanceToWitcher() + distance);
    }
}
