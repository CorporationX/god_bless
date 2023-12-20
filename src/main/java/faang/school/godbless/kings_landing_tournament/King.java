package faang.school.godbless.kings_landing_tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight lancelot = new Knight("Lancelot");
        Knight borc = new Knight("Borc");

        lancelot.addTrial(new Trial(lancelot.getName(), "Сражение cо львом"));
        borc.addTrial(new Trial(borc.getName(), "Сражение с медведем"));
        lancelot.addTrial(new Trial(lancelot.getName(), "Скачки на лошадях"));
        borc.addTrial(new Trial(borc.getName(), "Сражения на мечах"));
        lancelot.addTrial(new Trial(lancelot.getName(), "Сражение на мечах"));
        borc.addTrial(new Trial(borc.getName(), "Осада замка"));
        lancelot.addTrial(new Trial(lancelot.getName(), "Захват замка"));

        lancelot.startTrials();
        borc.startTrials();
    }
}

@Data
class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        this.trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (Trial trial : trials) {
            executorService.submit(trial);
        }
        executorService.shutdown();
    }
}

@Data
@AllArgsConstructor
class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - " + knightName + " проходит испытание " + trialName + " "); // это чтобы понять какой поток что делает
        try {
            Thread.sleep(new Random().nextInt(5000) + 1);
            System.out.println(knightName + ": Переходит на следующее ");
        } catch (
                InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}