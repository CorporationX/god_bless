package school.faang.bjs2_89577;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        validateKnight(name);
        this.name = name;
    }

    private static void validateKnight(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя рыцаря не может быть ни null, ни пустым!");
        }
    }

    public void addTrial(Trial trial) {
        ensureAddingTrialValid(trial, name, trials);
        trials.add(trial);
    }

    public void startTrials(ExecutorService executor) {
        Objects.requireNonNull(executor, "Пул потоков не может быть null");
        for (Trial trial : trials) {
            executor.execute(trial);
        }
    }

    private static void ensureAddingTrialValid(Trial addingTrial, String name, List<Trial> trials) {
        Objects.requireNonNull(addingTrial, "Рыцарь должен получать испытание, а не null!");
        if (!addingTrial.getKnightName().equalsIgnoreCase(name)) {
            throw new IllegalArgumentException("Нельзя давать рыцарю чужое испытание!");
        }
        for (Trial trial : trials) {
            if (trial.getTrialName().equalsIgnoreCase(addingTrial.getTrialName())) {
                throw new IllegalArgumentException("Нельзя давать рыцарю одни и те же испытания!");
            }
        }
    }
}
