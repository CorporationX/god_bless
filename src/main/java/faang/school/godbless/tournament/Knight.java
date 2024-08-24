package faang.school.godbless.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class Knight {
    private static final Logger log = LoggerFactory.getLogger(Knight.class);
    private String name;
    private final List<Trial> trials = new LinkedList<>();

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public void startTrials(ExecutorService executorService) {
        trials.forEach(executorService::submit);
    }

}