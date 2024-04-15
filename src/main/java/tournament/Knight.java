package tournament;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        if (trial == null) throw new NullPointerException("Trial must not be null");
        this.trials.add(trial);
    }

    public void startTrial() {
        for (int i = 0; i < trials.size(); i++) {
            this.trials.get(i).run();
        }
    }

    public static void main(String[] args) {
        Knight knight1 = new Knight("Artur");
        Knight knight2 = new Knight("Jon Snow");

        knight1.addTrial(new Trial(knight1.getName(), "Swimming"));
        knight1.addTrial(new Trial(knight1.getName(), "Archery"));

        knight2.addTrial(new Trial(knight2.getName(), "Archery"));
        knight2.addTrial(new Trial(knight2.getName(), "Run"));

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(knight1::startTrial);
        executor.submit(knight2::startTrial);

        executor.shutdown();
    }
}
