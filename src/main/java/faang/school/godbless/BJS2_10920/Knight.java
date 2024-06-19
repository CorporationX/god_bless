package faang.school.godbless.BJS2_10920;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter@ToString
public class Knight implements Runnable {
    private String name;
    private final List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        if (trial != null) {
            trials.add(trial);
        } else {
            throw new NullPointerException("Trial cannot be null");
        }
    }

    @Override
    public void run() {

        trials.stream()
                .filter(trial -> name.equals(trial.getKnightName()))
                .peek(trial -> {
                    System.out.println("Рыцарь " + name + " начал испытание " + trial.getTrialName() + "...");
                    try {
                        Thread.sleep((long) ((Math.random() * 31 + 1) * 1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Рыцарь " + name + " закончил испытание " + trial.getTrialName());
                }).toList();

    }
}
