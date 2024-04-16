package faang.school.godbless.multithreading.task_5;

import faang.school.godbless.multithreading.task_5.model.Chore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    private static final Chore[] chores = {
            new Chore("почистить обувь"), new Chore("помыть посуду"),
            new Chore("почистить клетки"), new Chore("приготовить еду")};

    public static void main(String[] args) {
        for (Chore chore : chores) {
            EXECUTOR.execute(chore);
        }
        EXECUTOR.shutdown();
    }
}