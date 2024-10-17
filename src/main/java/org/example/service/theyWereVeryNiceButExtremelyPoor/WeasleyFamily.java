package org.example.service.theyWereVeryNiceButExtremelyPoor;

import org.example.model.theyWereVeryNiceButExtremelyPoor.Chore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    public static List<Chore> works = new ArrayList<>();

    public static void addChore(Chore chore) {
        works.add(chore);
    }

    public static void gettingStartTheWorks(List<Chore> chores) {
        chores.forEach(EXECUTOR_SERVICE::submit);
        EXECUTOR_SERVICE.shutdown();
    }
}
