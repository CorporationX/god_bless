package faang.school.godbless.BJS2_10920;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        List<Knight> knights = new ArrayList<>();
        List<Trial> trials = new ArrayList<>();

        // для 20 рыцарей по 3 испытания
        for (int i = 1; i < 21; i++) {
            knights.add(new Knight("Knight" + i));
        }

        for (int i = 0; i < knights.size(); i++) {
            Knight knight = knights.get(i);

            for (int j = 1; j < 4; j++) {
                knight.addTrial(new Trial(knight.getName(), "Trial" + (3*i + j)));
            }
        }

        StartTrials(knights);

    }

    public static void StartTrials(List<Knight> knights) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        
        for (var knight: knights) {
            executorService.submit(knight);
        }
        
        executorService.shutdown();
    }
}
