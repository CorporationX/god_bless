package army.of.heroes.of.might.and.magic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Army {
    private List<Creature> army = new ArrayList<>();
    private List<CustomThread> threads = new ArrayList<>();

    public void addUnit(Optional<Creature> creature) {
        if (creature.isEmpty()) {
            throw new IllegalArgumentException("No unit added");
        }

        this.army.add(creature.get());
        this.threads.add(new CustomThread(creature.get()));
    }

    public int calculateTotalPower() {
        this.threads.forEach(CustomThread::start);

        this.threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return this.threads
            .stream()
            .mapToInt((thread) -> thread.getTotalPower().get())
            .sum();
    }
}
