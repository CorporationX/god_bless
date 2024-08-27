package ru.kraiush.threads.BJS2_23817;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppTournamentAtKingLanding {

    public static void main(String[] args) {

        Knight aragorn = new Knight("Aragorn");
        Knight baromir = new Knight("Baromir");

        Trial aragornFirst = new Trial(aragorn.getName(), "knight in the first battle ");
        Trial baromirFirst = new Trial(baromir.getName(), "knight in the first battle ");
        Trial aragornSecond = new Trial(baromir.getName(), "knight in the second battle");
        Trial baromirSecond = new Trial(aragorn.getName(), "knight in the second battle");

        List<Trial> listTrials = new ArrayList<>();
        addTrial(aragornFirst, listTrials);
        addTrial(baromirFirst, listTrials);
        addTrial(aragornSecond, listTrials);
        addTrial(baromirSecond, listTrials);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        startTrials(executor, listTrials);
    }

    static List<Trial> addTrial(Trial trial, List<Trial> listTrials) {
        listTrials.add(trial);
        return listTrials;
    }

    static void startTrials(ExecutorService executor, List<Trial> listTrials) {
        System.out.print(String.join("", Collections.nCopies(100, "-")));
        System.out.println("\n    <---  The battle has begun   --->");
        for (int i = 0; i < listTrials.size(); i++) {
            Runnable worker = listTrials.get(i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("\n Finished all battles!!!");
        System.out.print(String.join("", Collections.nCopies(100, "-")));
    }
}
