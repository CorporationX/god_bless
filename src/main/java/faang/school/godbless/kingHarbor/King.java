package faang.school.godbless.kingHarbor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight lanselot = new Knight("Ланселот");
        Knight persival = new Knight("Персиваль");
        lanselot.addTrial(new Trial(lanselot.getName(), "Сражение с огнендышашим драконом"));
        lanselot.addTrial(new Trial(lanselot.getName(), "Спасение крестьян"));
        persival.addTrial(new Trial(persival.getName(), "Сражение с ледяным драконом"));
        lanselot.addTrial(new Trial(persival.getName(), "Сражение с горными тролями"));

        lanselot.startTrials();
        persival.startTrials();
    }
}
