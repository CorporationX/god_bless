package faang.school.godbless.DiversificationHeroesOfMagic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private List<Character> characters;

    public Army(List<Character> characters) {
        this.characters = characters;
    }

    public int calculatePower() {
        ExecutorService executor = Executors.newFixedThreadPool(characters.size());
        List<Count> counts = new ArrayList<>();
        for (Character character : characters) {
            counts.add(new Count(character));
        }
        AtomicInteger result = new AtomicInteger();
        for (Count value : counts) {
            executor.submit(value);
        }
        executor.shutdown();
        counts.forEach(count -> result.addAndGet(count.getPower()));
        return result.get();
    }
}
