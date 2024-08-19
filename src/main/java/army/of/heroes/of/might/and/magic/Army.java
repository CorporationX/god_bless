package army.of.heroes.of.might.and.magic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Creature> army = new ArrayList<>();
    private List<CustomThread> threads = new ArrayList<>();

    public void addUnit(Creature creature){
        if(creature == null) {
            throw new IllegalArgumentException("No unit added");
        }

        this.army.add(creature);
        this.threads.add(new CustomThread(creature));
    }

    public int calculateTotalPower() {
        this.threads.forEach(CustomThread::run);

        return this.threads.stream().mapToInt(CustomThread::getTotalPower).sum();
    }
}
