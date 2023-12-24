package knight_1033;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        ExecutorService service = Executors.newFixedThreadPool(2);
        for (Trial trial : trials) {
            if (trial.getKnightName().equals(name)) {
                service.submit(trial);
            }
        }
        service.shutdown();
    }
}