package sprint4.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    private static final List<Trial> BASE_TRIALS = new ArrayList<>();

    static {
        BASE_TRIALS.add(new Trial("soft skills"));
        BASE_TRIALS.add(new Trial("hard skills"));
    }
    public static void main(String[] args) {
        Knight vlad = getTrainedKnight("Vlad");
        Knight vitaliy = getTrainedKnight("Vitaliy");
        ExecutorService service = Executors.newFixedThreadPool(2);

        System.out.println("The tournament has begun!");
        service.execute(vlad);
        service.execute(vitaliy);

        service.shutdown();
    }

    private static Knight getTrainedKnight(String name) {
        Knight knight = new Knight(name);
        knight.addTrials(BASE_TRIALS);
        return knight;
    }
}
