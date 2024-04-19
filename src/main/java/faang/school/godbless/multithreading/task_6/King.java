package faang.school.godbless.multithreading.task_6;

import faang.school.godbless.multithreading.task_6.model.Knight;
import faang.school.godbless.multithreading.task_6.model.Trial;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    private static final int POOL_SIZE = 2;

    public static void main(String[] args) {
        Knight ignat = new Knight("ignat");
        Knight magomed = new Knight("magomed");
        String ignatName = ignat.getName();
        String magomedName = magomed.getName();
        Trial firstIgnatTrial = new Trial(ignatName, "first Ignat Trial");
        Trial secondIgnatTrial = new Trial(ignatName, "second Ignat Trial");
        Trial firstMagomedTrial = new Trial(magomedName, "first Magomed Trial");
        Trial secondMagomedTrial = new Trial(magomedName, "second Magomed Trial");
        ignat.addTrial(firstIgnatTrial);
        ignat.addTrial(secondIgnatTrial);
        magomed.addTrial(firstMagomedTrial);
        magomed.addTrial(secondMagomedTrial);
        startAllTrials(List.of(ignat, magomed));
    }

    private static void startAllTrials(List<Knight> knights) {
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        knights.forEach(knight -> executor.execute(knight::startTrials));
        executor.shutdown();
    }
}
