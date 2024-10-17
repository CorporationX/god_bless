package ru.kraiush.BJS2_36696;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    private static final int THREAD_POOL_SIZE = 4;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        Task theoryPreparation = new Task("Sheldon", "theory preparation");
        Task experimentalDesign = new Task("Leonard", "experimental design");
        Task instrumentDevelopment = new Task("Howard", "instrument development");
        Task dataAnalysis = new Task("Rajesh", "data analysis");

        executorService.submit(theoryPreparation);
        executorService.submit(experimentalDesign);
        executorService.submit(instrumentDevelopment);
        executorService.submit(dataAnalysis);

        executorService.shutdown();
    }
}
