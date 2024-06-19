package faang.school.godbless.multithreading.kings;

import java.util.concurrent.Executors;

public class King {

    public static void main(String[] args) {
        var loras = new Knight("Sir Loras");
        var theMountain = new Knight("The Mountain");
        loras.addTrial(new Trial(loras.getName(), "racing"));
        loras.addTrial(new Trial(loras.getName(), "battling"));
        theMountain.addTrial(new Trial(theMountain.getName(), "racing"));
        theMountain.addTrial(new Trial(theMountain.getName(), "battling"));
        startTrials(loras, theMountain);
    }

    public static void startTrials(Knight firstKnight, Knight secondKnight) {
        var threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(firstKnight);
        threadPool.submit(secondKnight);
        threadPool.shutdown();
    }
}
