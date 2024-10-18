package ru.kraiush.BJS2_35764;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    private static final int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) {
        Knight borosBlount = new Knight("Ser Boros Blount");
        Knight nedStark = new Knight("Ned Stark");

        borosBlount.addTrial(new Trial(borosBlount.getName(), "Jousting"));
        borosBlount.addTrial(new Trial(borosBlount.getName(), "Melee"));
        nedStark.addTrial(new Trial(nedStark.getName(), "Archery"));
        nedStark.addTrial(new Trial(nedStark.getName(), "Footrace"));
        nedStark.addTrial(new Trial(nedStark.getName(), "Sword Fighting"));

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        borosBlount.startTrials(executorService);
        nedStark.startTrials(executorService);

        executorService.shutdown();

        try {
            executorService.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("The trials were interrupted and not completed!");
        }
    }
}
