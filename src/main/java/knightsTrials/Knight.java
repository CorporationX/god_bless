package knightsTrials;

import lombok.Getter;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Getter
public class Knight {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);
    private String name;
    private ArrayList<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    void addTrial(Trial trial) {
        if(name==trial.getKnightName()) {
            trials.add(trial);
        }
        else {
            throw new IllegalArgumentException("Вы пытаетесь присвоить рыцарю не его испытание");
        }
    }

    void startTrials() {

        for(Trial trial:trials){
            executorService.submit(() -> trial.run());
        }
        //executorService.shutdown();
    }

}
