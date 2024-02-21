package tournament;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Knight implements Runnable {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " начинает работу");
            Thread.sleep(3000);
            startTrial();
        } catch (InterruptedException e) {

        }
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrial() {
        for (Trial trial : trials) {
            new Thread(() -> System.out.println(trial.getKnightName() + " выполняет задачу " + trial.getTrialName())).start();
        }
    }
}
