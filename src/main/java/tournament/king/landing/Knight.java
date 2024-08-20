package tournament.king.landing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>();

    Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        this.trials.add(trial);
    }

    public void startTrial(ExecutorService service) {
        if (this.trials.isEmpty()) {
            service.shutdown();
            throw new IllegalArgumentException("У рыцаря отсутствуют испытания");
        }

        this.trials.forEach(service::submit);
    }
}
