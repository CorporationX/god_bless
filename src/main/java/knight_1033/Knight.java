package knight_1033;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials() {
        System.out.println(Thread.currentThread().getName() + " Начинаем запуск испытаний для рыцаря - " + name);

        for (Trial trial : trials) {
            if (trial.getKnightName().equals(name)) {
                Thread thread = new Thread(() -> trial.run());
                thread.start();
            }
        }
    }
}