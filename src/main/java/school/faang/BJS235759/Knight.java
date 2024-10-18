package school.faang.BJS235759;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
@AllArgsConstructor
public class Knight {
    private String name;
    private List<Trial> trialList;

    public void addTrial(Trial trial) {
        trialList.add(trial);
    }

    public void startTrials() {
        System.out.println(name + " начинает подвиг");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        trialList.forEach(executorService::execute);
        executorService.shutdown();
    }
}
