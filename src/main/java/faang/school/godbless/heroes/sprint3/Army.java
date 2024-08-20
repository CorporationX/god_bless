package faang.school.godbless.heroes.sprint3;

import faang.school.godbless.heroes.sprint3.creature.Creature;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class Army {

    private final Logger logger = LoggerFactory.getLogger(Army.class);
    private final List<Creature> units;

    public Army() {
        units = new ArrayList<>();
    }

    public void addUnit(Creature creature) {
        units.add(creature);
    }

    public long calculateTotalPower() {

        Map<String, List<PowerThread>> creatureThreadsMap = units.stream()
                .collect(Collectors.groupingBy(Creature::getName))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().map(PowerThread::new).toList()));

        List<PowerThread> powerThreads = creatureThreadsMap.values().stream()
                .flatMap(Collection::stream)
                .toList();

        powerThreads.forEach(PowerThread::start);
        try {
            for (PowerThread powerThread : powerThreads) {
                powerThread.join();
            }
        } catch (InterruptedException exception) {
            logger.error("An error occurred while calculating total power", exception);
        }

        Map<String, Long> creaturePower = creatureThreadsMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
                        .mapToLong(PowerThread::getPower)
                        .sum()));

        return creaturePower.values().stream()
                .mapToLong(l -> l)
                .sum();
    }
}
