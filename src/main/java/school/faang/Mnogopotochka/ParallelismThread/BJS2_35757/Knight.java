package school.faang.Mnogopotochka.ParallelismThread.BJS2_35757;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
@AllArgsConstructor
public class Knight {
    private String name;
    private List<Trial> trails;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Knight firstKnight = new Knight("Dark", new ArrayList<>());
        Knight secodKnight = new Knight("White", new ArrayList<>());

        String[] trialNames = {
                "Trial of Courage",
                "Trial of Honor",
                "Trial of Strength",
                "Trial of Wisdom",
                "Trial of Endurance",
                "Trial of Loyalty",
                "Trial of Justice",
                "Trial of Patience",
                "Trial of Faith",
                "Trial of Leadership"
        };

        addTrial(firstKnight, trialNames);
        addTrial(secodKnight, trialNames);

        firstKnight.startTrials(executorService);
        secodKnight.startTrials(executorService);

        executorService.shutdown();
    }

    private void startTrials(ExecutorService executorService) {
        trails.forEach(executorService::submit);
    }

    private static void addTrial(Knight knight, String[] trialNames) {
        for (String trialName : trialNames) {
            knight.getTrails().add(new Trial(knight.getName(), trialName));
        }
    }
}
