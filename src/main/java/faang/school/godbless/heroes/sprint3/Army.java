package faang.school.godbless.heroes.sprint3;

import faang.school.godbless.heroes.sprint3.creature.Creature;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class Army {

    private final List<Creature> units;

    public Army() {
        units = new ArrayList<>();
    }

    public void addUnit(Creature creature) {
        units.add(creature);
    }

    public long calculateTotalPower() {

        Map<String, PowerThread> creatureThreadMap = units.stream()
                .collect(Collectors.groupingBy(Creature::getName))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> new PowerThread(entry.getValue())
                ));

        creatureThreadMap.values().forEach(PowerThread::start);

        try {
            for (PowerThread powerThread : creatureThreadMap.values()) {
                powerThread.join();
            }
        } catch (InterruptedException exception) {
            log.error("An error occurred while calculating total power", exception);
        }

        return creatureThreadMap.values().stream()
                .mapToLong(PowerThread::getPower)
                .sum();
    }
}
